package kpi.supplychain.gui.configuration;

import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.service.configuration.FirstTransportationProblemSolver;
import kpi.supplychain.service.configuration.InventoryManagment;
import kpi.supplychain.service.configuration.TransportationProblemSolver;
import kpi.supplychain.service.configuration.NetworkService;
import lpsolve.LpSolveException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow {

    @Autowired
    private NetworkService networkService;

    @Autowired
    private InventoryManagment inventoryManagment;

    @Autowired
    private FirstTransportationProblemSolver firstTransportationProblemSolver;

    @Autowired
    private TransportationProblemSolver transportationProblemSolver;

    private Network network;
    private JFrame frame;
    private JButton newSolutionButton;
    private JButton solveSolutionButton;
    private JComboBox regionCount;
    private JComboBox durationCycle;
    private JComboBox reserveLayer;
    private JProgressBar progressBar;

    public MainWindow() {
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        network = networkService.getNetwork();

        JPanel panel = new JPanel();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        GraphFrame graphFrame = new GraphFrame();
        graphFrame.setNetwork(network);
        graphFrame.init();
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout
                .createParallelGroup(Alignment.LEADING)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                .addGroup(
                        groupLayout.createSequentialGroup().addContainerGap().addComponent(graphFrame, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                                .addContainerGap())
                .addGroup(
                        groupLayout.createSequentialGroup().addContainerGap().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                                .addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
                groupLayout.createSequentialGroup().addComponent(panel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(graphFrame, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));

        newSolutionButton = new JButton("Новая конфигурация");
        newSolutionButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                network = networkService.getNetwork();
                solveSolutionButton.setEnabled(true);
                progressBar.setValue(0);
                regionCount.setEnabled(true);
                durationCycle.setEnabled(true);
            }
        });
        panel.add(newSolutionButton);

        regionCount = new JComboBox();
        regionCount.setModel(new DefaultComboBoxModel(new String[]{"6 региональных складов", "7 региональных складов", "8 региональных складов",
                "9 региональных складов", "10 региональных складов"}));
        panel.add(regionCount);

        durationCycle = new JComboBox();
        durationCycle.setModel(new DefaultComboBoxModel(new String[]{"2 недели", "3 недели", "4 недели"}));
        panel.add(durationCycle);

        solveSolutionButton = new JButton("Решить");

        reserveLayer = new JComboBox();
        reserveLayer.setModel(new DefaultComboBoxModel(new String[]{"68,2%", "95.4%", "99.6%"}));
        panel.add(reserveLayer);

        progressBar = new JProgressBar();
        panel.add(progressBar);

        solveSolutionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveSolutionButton.setEnabled(false);
                newSolutionButton.setEnabled(false);
                regionCount.setEnabled(false);
                durationCycle.setEnabled(false);
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            int regCount = regionCount.getSelectedIndex() + 6;
                            int week = durationCycle.getSelectedIndex() + 2;
                            int reserve = reserveLayer.getSelectedIndex() + 1;
                            network.setReserveCoef(reserve);
                            firstTransportationProblemSolver.setN(regCount);
                            firstTransportationProblemSolver.setWeeks(week);
                            firstTransportationProblemSolver.solveProblem(network);
                            progressBar.setValue(33);
                            network.notifyObservers();
                            inventoryManagment.solve(week, network);
                            double[] distance = new double[]{851, 1322, 819, 1286, 976, 500, 0, 478, 553, 476, 479, 811, 143, 432, 731, 434, 476, 716, 793,
                                    0, 133, 466, 502, 795, 732, 467};
                            transportationProblemSolver.setUp(false, regCount, week);
                            transportationProblemSolver.setA(network);
                            transportationProblemSolver.setB(network);
                            transportationProblemSolver.setDistances(distance);
                            transportationProblemSolver.solveTransportationProblem(0, null, null, week, network);
                            progressBar.setValue(66);
                            network.notifyObservers();
                            inventoryManagment.solveNationalProblem(network);
                            network.writeDataForSimulationModel(week);
                        } catch (LpSolveException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        newSolutionButton.setEnabled(true);
                        StringBuilder builder = new StringBuilder();
                        builder.append("Затраты на транспортировку локального уровня:").append(network.getLocalTransportCost() + "\n");
                        builder.append("Затраты на транспортировку регионального уровня:").append(network.getRegionTransportCost() + "\n");
                        builder.append("Затраты на хранение на реиональном уровне:").append(network.getRegionWarehouseCost() + "\n");
                        builder.append("Затраты на хранение на национальном уровне:").append(network.getNatonalWarehouseCost() + "\n");
                        builder.append("Общие затраты:").append(
                                (network.getLocalTransportCost() + network.getRegionTransportCost() + network.getRegionWarehouseCost() + network.getNatonalWarehouseCost()) + "\n");

                        JOptionPane.showConfirmDialog(frame, builder.toString(), "Результаты", JOptionPane.CLOSED_OPTION);

                        System.out.println("___________________________________________________");

                        System.out.println("Local transport:" + network.getLocalTransportCost());
                        System.out.println("Region transport:" + network.getRegionTransportCost());
                        System.out.println("Region warehouse:" + network.getRegionWarehouseCost());
                        System.out.println("National warehouse:" + network.getNatonalWarehouseCost());

                        System.out.println("Total:"
                                + (network.getLocalTransportCost() + network.getRegionTransportCost() + network.getRegionWarehouseCost() + network.getNatonalWarehouseCost()));
                    }
                }).start();
            }
        });
        panel.add(solveSolutionButton);

        JTable table = new JTable();
        MatrixTableModel matrixTableModel = new MatrixTableModel();
        matrixTableModel.setNetwork(network);
        network.addObserver(matrixTableModel);
        table.setModel(matrixTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setMinWidth(200);
        scrollPane.setViewportView(table);
        frame.getContentPane().setLayout(groupLayout);
    }

    public JFrame getFrame() {
        return frame;
    }
}
