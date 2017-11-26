/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kpi.supplychain.gui.statistics;

import kpi.supplychain.dao.*;
import kpi.supplychain.dao.configuration.RegionLayerDao;
import kpi.supplychain.dao.configuration.RegionalValuesDao;
import kpi.supplychain.pojo.*;
import kpi.supplychain.pojo.ConfigParams;
import kpi.supplychain.pojo.configuration.RegionLayer;
import kpi.supplychain.pojo.configuration.RegionalValues;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainFrame extends JFrame {

    private javax.swing.JComboBox jComboBoxConfigIndex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelRegStorage10Skipped;
    private javax.swing.JLabel jLabelRegStorage1Skipped1;
    private javax.swing.JLabel jLabelRegStorage2Skipped;
    private javax.swing.JLabel jLabelRegStorage3Skipped;
    private javax.swing.JLabel jLabelRegStorage4Skipped;
    private javax.swing.JLabel jLabelRegStorage5Skipped;
    private javax.swing.JLabel jLabelRegStorage6Skipped;
    private javax.swing.JLabel jLabelRegStorage7Skipped;
    private javax.swing.JLabel jLabelRegStorage8Skipped;
    private javax.swing.JLabel jLabelRegStorage9Skipped;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollBar jScrollBarEfficiencyX;
    private javax.swing.JScrollBar jScrollBarEfficiencyY;
    private javax.swing.JScrollBar jScrollBarExperimentsX;
    private javax.swing.JScrollBar jScrollBarExperimentsY;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSliderEfficiency;
    private javax.swing.JSlider jSliderExperiments;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableExperiments;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldCycleLength;
    private javax.swing.JTextField jTextFieldNetWorkDegree;
    private javax.swing.JTextField jTextFieldRegStorage10City;
    private javax.swing.JTextField jTextFieldRegStorage10Degree;
    private javax.swing.JTextField jTextFieldRegStorage10Shortage;
    private javax.swing.JTextField jTextFieldRegStorage10Supplied;
    private javax.swing.JTextField jTextFieldRegStorage1City;
    private javax.swing.JTextField jTextFieldRegStorage1Degree;
    private javax.swing.JTextField jTextFieldRegStorage1Shortage;
    private javax.swing.JTextField jTextFieldRegStorage1Supplied;
    private javax.swing.JTextField jTextFieldRegStorage2City;
    private javax.swing.JTextField jTextFieldRegStorage2Degree;
    private javax.swing.JTextField jTextFieldRegStorage2Shortage;
    private javax.swing.JTextField jTextFieldRegStorage2Supplied;
    private javax.swing.JTextField jTextFieldRegStorage3City;
    private javax.swing.JTextField jTextFieldRegStorage3Degree;
    private javax.swing.JTextField jTextFieldRegStorage3Shortage;
    private javax.swing.JTextField jTextFieldRegStorage3Supplied;
    private javax.swing.JTextField jTextFieldRegStorage4City;
    private javax.swing.JTextField jTextFieldRegStorage4Degree;
    private javax.swing.JTextField jTextFieldRegStorage4Shortage;
    private javax.swing.JTextField jTextFieldRegStorage4Supplied;
    private javax.swing.JTextField jTextFieldRegStorage5City;
    private javax.swing.JTextField jTextFieldRegStorage5Degree;
    private javax.swing.JTextField jTextFieldRegStorage5Shortage;
    private javax.swing.JTextField jTextFieldRegStorage5Supplied;
    private javax.swing.JTextField jTextFieldRegStorage6City;
    private javax.swing.JTextField jTextFieldRegStorage6Degree;
    private javax.swing.JTextField jTextFieldRegStorage6Shortage;
    private javax.swing.JTextField jTextFieldRegStorage6Supplied;
    private javax.swing.JTextField jTextFieldRegStorage7City;
    private javax.swing.JTextField jTextFieldRegStorage7Degree;
    private javax.swing.JTextField jTextFieldRegStorage7Shortage;
    private javax.swing.JTextField jTextFieldRegStorage7Supplied;
    private javax.swing.JTextField jTextFieldRegStorage8City;
    private javax.swing.JTextField jTextFieldRegStorage8Degree;
    private javax.swing.JTextField jTextFieldRegStorage8Shortage;
    private javax.swing.JTextField jTextFieldRegStorage8Supplied;
    private javax.swing.JTextField jTextFieldRegStorage9City;
    private javax.swing.JTextField jTextFieldRegStorage9Degree;
    private javax.swing.JTextField jTextFieldRegStorage9Shortage;
    private javax.swing.JTextField jTextFieldRegStorage9Supplied;
    private javax.swing.JTextField jTextFieldRegStorageCount;
    private javax.swing.JTextField jTextFieldReserveStorage;
    private JPanelGraphExperiments jPanelGraphExperiments1;
    private JPanelGraphEfficientArray jPanelGraphEfficientArray;
    private JPanelGraphEfficientArray jPanelGraphEfficientArray1;

    @Autowired
    private ExperimentDAO experimentDAO;
    @Autowired
    private RegionalValuesDao regionalValuesDAO;
    @Autowired
    private NetworkConfigDAO networkConfigDAO;
    @Autowired
    private ConfigParamsDao configParamsDao;
    @Autowired
    private RegionLayerDao regionLayerDao;


    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        /*initComponents();*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableExperiments = new javax.swing.JTable();
        jSliderExperiments = new javax.swing.JSlider();
        jPanelGraphExperiments1 = new JPanelGraphExperiments();
        jScrollBarExperimentsY = new javax.swing.JScrollBar();
        jScrollBarExperimentsX = new javax.swing.JScrollBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxConfigIndex = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldRegStorageCount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCycleLength = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldReserveStorage = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldRegStorage2City = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldRegStorage2Supplied = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldRegStorage2Shortage = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldRegStorage2Degree = new javax.swing.JTextField();
        jLabelRegStorage2Skipped = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldRegStorage1City = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldRegStorage1Supplied = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldRegStorage1Shortage = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldRegStorage1Degree = new javax.swing.JTextField();
        jLabelRegStorage1Skipped1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldRegStorage3City = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldRegStorage3Supplied = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldRegStorage3Shortage = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextFieldRegStorage3Degree = new javax.swing.JTextField();
        jLabelRegStorage3Skipped = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldRegStorage4City = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldRegStorage4Supplied = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextFieldRegStorage4Shortage = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldRegStorage4Degree = new javax.swing.JTextField();
        jLabelRegStorage4Skipped = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldRegStorage5City = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextFieldRegStorage5Supplied = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldRegStorage5Shortage = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextFieldRegStorage5Degree = new javax.swing.JTextField();
        jLabelRegStorage5Skipped = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextFieldRegStorage6City = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldRegStorage6Supplied = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldRegStorage6Shortage = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextFieldRegStorage6Degree = new javax.swing.JTextField();
        jLabelRegStorage6Skipped = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextFieldRegStorage10City = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jTextFieldRegStorage10Supplied = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jTextFieldRegStorage10Shortage = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextFieldRegStorage10Degree = new javax.swing.JTextField();
        jLabelRegStorage10Skipped = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextFieldRegStorage8City = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextFieldRegStorage8Supplied = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextFieldRegStorage8Shortage = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextFieldRegStorage8Degree = new javax.swing.JTextField();
        jLabelRegStorage8Skipped = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextFieldRegStorage7City = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextFieldRegStorage7Supplied = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextFieldRegStorage7Shortage = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextFieldRegStorage7Degree = new javax.swing.JTextField();
        jLabelRegStorage7Skipped = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jTextFieldRegStorage9City = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextFieldRegStorage9Supplied = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jTextFieldRegStorage9Shortage = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextFieldRegStorage9Degree = new javax.swing.JTextField();
        jLabelRegStorage9Skipped = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextFieldNetWorkDegree = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanelGraphEfficientArray1 = new JPanelGraphEfficientArray();
        jScrollBarEfficiencyY = new javax.swing.JScrollBar();
        jScrollBarEfficiencyX = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSliderEfficiency = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diploma Bachelor");

        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Количество экспериментов:");

        jTextField1.setEditable(false);

        jTableExperiments.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane2.setViewportView(jTableExperiments);

        jSliderExperiments.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderExperiments.setToolTipText("Масштабирование");
        jSliderExperiments.setValue(0);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSliderExperiments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jSliderExperiments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanelGraphExperiments1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelGraphExperiments1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelGraphExperiments1MouseClicked(evt);
            }
        });
        jPanelGraphExperiments1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelGraphExperiments1MouseMoved(evt);
            }
        });

        jScrollBarExperimentsY.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                jScrollBarExperimentsYAdjustmentValueChanged(evt);
            }
        });

        jScrollBarExperimentsX.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        jScrollBarExperimentsX.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                jScrollBarExperimentsXAdjustmentValueChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelGraphExperiments1Layout = new javax.swing.GroupLayout(jPanelGraphExperiments1);
        jPanelGraphExperiments1.setLayout(jPanelGraphExperiments1Layout);
        jPanelGraphExperiments1Layout.setHorizontalGroup(
            jPanelGraphExperiments1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGraphExperiments1Layout.createSequentialGroup()
                .addComponent(jScrollBarExperimentsX, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBarExperimentsY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelGraphExperiments1Layout.setVerticalGroup(
            jPanelGraphExperiments1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGraphExperiments1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollBarExperimentsX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelGraphExperiments1Layout.createSequentialGroup()
                .addComponent(jScrollBarExperimentsY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelGraphExperiments1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGraphExperiments1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Все эксперименты", jPanel1);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jLabel2.setText("Вариант конфигурации:");

        jComboBoxConfigIndex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45" }));
        jComboBoxConfigIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConfigIndexActionPerformed(evt);
            }
        });
        jComboBoxConfigIndex.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxConfigIndexPropertyChange(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Статистика по региональным складам");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Количество региональных складов:");

        jTextFieldRegStorageCount.setEditable(false);
        jTextFieldRegStorageCount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Длительность цикла поставок:");

        jTextFieldCycleLength.setEditable(false);
        jTextFieldCycleLength.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("недели");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Размер страхового запаса:");

        jTextFieldReserveStorage.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("%");

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Региональный склад №2");

        jLabel5.setText("Размещен:");

        jTextFieldRegStorage2City.setEditable(false);
        jTextFieldRegStorage2City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setText("Объем поставок:");

        jTextFieldRegStorage2Supplied.setEditable(false);
        jTextFieldRegStorage2Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setText("Объем дефицита:");

        jTextFieldRegStorage2Shortage.setEditable(false);
        jTextFieldRegStorage2Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setText("Уровень сервиса:");

        jTextFieldRegStorage2Degree.setEditable(false);
        jTextFieldRegStorage2Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage2Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage2Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage2Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(54, 54, 54))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage2Skipped))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldRegStorage2Degree, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(jTextFieldRegStorage2Supplied)
                                .addComponent(jTextFieldRegStorage2City))
                            .addComponent(jTextFieldRegStorage2Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldRegStorage2City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldRegStorage2Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldRegStorage2Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldRegStorage2Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage2Skipped)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Региональный склад №1");

        jLabel15.setText("Размещен:");

        jTextFieldRegStorage1City.setEditable(false);
        jTextFieldRegStorage1City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel16.setText("Объем поставок:");

        jTextFieldRegStorage1Supplied.setEditable(false);
        jTextFieldRegStorage1Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel17.setText("Объем дефицита:");

        jTextFieldRegStorage1Shortage.setEditable(false);
        jTextFieldRegStorage1Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setText("Уровень сервиса:");

        jTextFieldRegStorage1Degree.setEditable(false);
        jTextFieldRegStorage1Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage1Skipped1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage1Skipped1.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage1Skipped1.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(54, 54, 54))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage1Skipped1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldRegStorage1Supplied, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(jTextFieldRegStorage1Shortage)
                                .addComponent(jTextFieldRegStorage1City))
                            .addComponent(jTextFieldRegStorage1Degree, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldRegStorage1City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldRegStorage1Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldRegStorage1Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldRegStorage1Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage1Skipped1)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Региональный склад №3");

        jLabel20.setText("Размещен:");

        jTextFieldRegStorage3City.setEditable(false);
        jTextFieldRegStorage3City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel21.setText("Объем поставок:");

        jTextFieldRegStorage3Supplied.setEditable(false);
        jTextFieldRegStorage3Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setText("Объем дефицита:");

        jTextFieldRegStorage3Shortage.setEditable(false);
        jTextFieldRegStorage3Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setText("Уровень сервиса:");

        jTextFieldRegStorage3Degree.setEditable(false);
        jTextFieldRegStorage3Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage3Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage3Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage3Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(54, 54, 54))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage3Skipped))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldRegStorage3Degree, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jTextFieldRegStorage3City)
                            .addComponent(jTextFieldRegStorage3Supplied)
                            .addComponent(jTextFieldRegStorage3Shortage))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldRegStorage3City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldRegStorage3Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldRegStorage3Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextFieldRegStorage3Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage3Skipped)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Региональный склад №4");

        jLabel25.setText("Размещен:");

        jTextFieldRegStorage4City.setEditable(false);
        jTextFieldRegStorage4City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel26.setText("Объем поставок:");

        jTextFieldRegStorage4Supplied.setEditable(false);
        jTextFieldRegStorage4Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel27.setText("Объем дефицита:");

        jTextFieldRegStorage4Shortage.setEditable(false);
        jTextFieldRegStorage4Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel28.setText("Уровень сервиса:");

        jTextFieldRegStorage4Degree.setEditable(false);
        jTextFieldRegStorage4Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage4Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage4Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage4Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(54, 54, 54))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage4Skipped))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel25)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldRegStorage4Degree, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jTextFieldRegStorage4City)
                            .addComponent(jTextFieldRegStorage4Supplied)
                            .addComponent(jTextFieldRegStorage4Shortage))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextFieldRegStorage4City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jTextFieldRegStorage4Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(jTextFieldRegStorage4Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jTextFieldRegStorage4Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage4Skipped)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Региональный склад №5");

        jLabel30.setText("Размещен:");

        jTextFieldRegStorage5City.setEditable(false);
        jTextFieldRegStorage5City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel31.setText("Объем поставок:");

        jTextFieldRegStorage5Supplied.setEditable(false);
        jTextFieldRegStorage5Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel32.setText("Объем дефицита:");

        jTextFieldRegStorage5Shortage.setEditable(false);
        jTextFieldRegStorage5Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel33.setText("Уровень сервиса:");

        jTextFieldRegStorage5Degree.setEditable(false);
        jTextFieldRegStorage5Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage5Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage5Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage5Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(54, 54, 54))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldRegStorage5Degree, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel31)
                                .addComponent(jLabel30)
                                .addComponent(jLabel32))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldRegStorage5City, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                .addComponent(jTextFieldRegStorage5Supplied)
                                .addComponent(jTextFieldRegStorage5Shortage))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage5Skipped)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextFieldRegStorage5City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextFieldRegStorage5Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(jTextFieldRegStorage5Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextFieldRegStorage5Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage5Skipped)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Региональный склад №6");

        jLabel35.setText("Размещен:");

        jTextFieldRegStorage6City.setEditable(false);
        jTextFieldRegStorage6City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel36.setText("Объем поставок:");

        jTextFieldRegStorage6Supplied.setEditable(false);
        jTextFieldRegStorage6Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel37.setText("Объем дефицита:");

        jTextFieldRegStorage6Shortage.setEditable(false);
        jTextFieldRegStorage6Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel38.setText("Уровень сервиса:");

        jTextFieldRegStorage6Degree.setEditable(false);
        jTextFieldRegStorage6Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage6Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage6Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage6Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(54, 54, 54))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage6Skipped))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldRegStorage6Degree)
                            .addComponent(jTextFieldRegStorage6Supplied, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jTextFieldRegStorage6Shortage)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRegStorage6City)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jTextFieldRegStorage6City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextFieldRegStorage6Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(jTextFieldRegStorage6Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jTextFieldRegStorage6Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage6Skipped)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Региональный склад №10");

        jLabel55.setText("Размещен:");

        jTextFieldRegStorage10City.setEditable(false);
        jTextFieldRegStorage10City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel56.setText("Объем поставок:");

        jTextFieldRegStorage10Supplied.setEditable(false);
        jTextFieldRegStorage10Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel57.setText("Объем дефицита:");

        jTextFieldRegStorage10Shortage.setEditable(false);
        jTextFieldRegStorage10Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel58.setText("Уровень сервиса:");

        jTextFieldRegStorage10Degree.setEditable(false);
        jTextFieldRegStorage10Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage10Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage10Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage10Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel54)
                .addGap(54, 54, 54))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage10Skipped))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldRegStorage10Degree)
                            .addComponent(jTextFieldRegStorage10Shortage)
                            .addComponent(jTextFieldRegStorage10Supplied, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldRegStorage10City, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextFieldRegStorage10City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jTextFieldRegStorage10Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel57)
                    .addComponent(jTextFieldRegStorage10Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jTextFieldRegStorage10Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage10Skipped)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Региональный склад №8");

        jLabel45.setText("Размещен:");

        jTextFieldRegStorage8City.setEditable(false);
        jTextFieldRegStorage8City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel46.setText("Объем поставок:");

        jTextFieldRegStorage8Supplied.setEditable(false);
        jTextFieldRegStorage8Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel47.setText("Объем дефицита:");

        jTextFieldRegStorage8Shortage.setEditable(false);
        jTextFieldRegStorage8Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel48.setText("Уровень сервиса:");

        jTextFieldRegStorage8Degree.setEditable(false);
        jTextFieldRegStorage8Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage8Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage8Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage8Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel44)
                .addGap(54, 54, 54))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage8Skipped))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel45)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldRegStorage8Degree, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(jTextFieldRegStorage8City)
                            .addComponent(jTextFieldRegStorage8Shortage)
                            .addComponent(jTextFieldRegStorage8Supplied))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextFieldRegStorage8City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextFieldRegStorage8Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel47)
                    .addComponent(jTextFieldRegStorage8Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jTextFieldRegStorage8Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage8Skipped)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Региональный склад №7");

        jLabel40.setText("Размещен:");

        jTextFieldRegStorage7City.setEditable(false);
        jTextFieldRegStorage7City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel41.setText("Объем поставок:");

        jTextFieldRegStorage7Supplied.setEditable(false);
        jTextFieldRegStorage7Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel42.setText("Объем дефицита:");

        jTextFieldRegStorage7Shortage.setEditable(false);
        jTextFieldRegStorage7Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel43.setText("Уровень сервиса:");

        jTextFieldRegStorage7Degree.setEditable(false);
        jTextFieldRegStorage7Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage7Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage7Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage7Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(54, 54, 54))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage7Skipped))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldRegStorage7Degree, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(jTextFieldRegStorage7Supplied)
                                .addComponent(jTextFieldRegStorage7Shortage))
                            .addComponent(jTextFieldRegStorage7City, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jTextFieldRegStorage7City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextFieldRegStorage7Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42)
                    .addComponent(jTextFieldRegStorage7Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jTextFieldRegStorage7Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage7Skipped)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Региональный склад №9");

        jLabel50.setText("Размещен:");

        jTextFieldRegStorage9City.setEditable(false);
        jTextFieldRegStorage9City.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel51.setText("Объем поставок:");

        jTextFieldRegStorage9Supplied.setEditable(false);
        jTextFieldRegStorage9Supplied.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel52.setText("Объем дефицита:");

        jTextFieldRegStorage9Shortage.setEditable(false);
        jTextFieldRegStorage9Shortage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel53.setText("Уровень сервиса:");

        jTextFieldRegStorage9Degree.setEditable(false);
        jTextFieldRegStorage9Degree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabelRegStorage9Skipped.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRegStorage9Skipped.setForeground(new java.awt.Color(255, 0, 0));
        jLabelRegStorage9Skipped.setText("Поставок не совершалось");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(54, 54, 54))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelRegStorage9Skipped))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldRegStorage9Degree, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jTextFieldRegStorage9City)
                            .addComponent(jTextFieldRegStorage9Supplied)
                            .addComponent(jTextFieldRegStorage9Shortage))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextFieldRegStorage9City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTextFieldRegStorage9Supplied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel52)
                    .addComponent(jTextFieldRegStorage9Shortage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextFieldRegStorage9Degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegStorage9Skipped)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel59.setText("Сетевой уровень сервиса");

        jTextFieldNetWorkDegree.setEditable(false);
        jTextFieldNetWorkDegree.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel60.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldRegStorageCount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCycleLength, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldReserveStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNetWorkDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel60))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxConfigIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247)
                        .addComponent(jLabel3)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxConfigIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldRegStorageCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldCycleLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldReserveStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel59)
                    .addComponent(jTextFieldNetWorkDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Статистика по региональным складам", jPanel2);

        jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel3ComponentShown(evt);
            }
        });

        jPanelGraphEfficientArray1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelGraphEfficientArray1MouseClicked(evt);
            }
        });
        jPanelGraphEfficientArray1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanelGraphEfficientArray1MouseMoved(evt);
            }
        });

        jScrollBarEfficiencyY.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                jScrollBarEfficiencyYAdjustmentValueChanged(evt);
            }
        });

        jScrollBarEfficiencyX.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        jScrollBarEfficiencyX.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                jScrollBarEfficiencyXAdjustmentValueChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanelGraphEfficientArray1Layout = new javax.swing.GroupLayout(jPanelGraphEfficientArray1);
        jPanelGraphEfficientArray1.setLayout(jPanelGraphEfficientArray1Layout);
        jPanelGraphEfficientArray1Layout.setHorizontalGroup(
            jPanelGraphEfficientArray1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGraphEfficientArray1Layout.createSequentialGroup()
                .addComponent(jScrollBarEfficiencyX, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBarEfficiencyY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelGraphEfficientArray1Layout.setVerticalGroup(
            jPanelGraphEfficientArray1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBarEfficiencyY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelGraphEfficientArray1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollBarEfficiencyX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jSliderEfficiency.setOrientation(javax.swing.JSlider.VERTICAL);
        jSliderEfficiency.setToolTipText("Macштабирование");
        jSliderEfficiency.setValue(0);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelGraphEfficientArray1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelGraphEfficientArray1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jSliderEfficiency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Множество эффективных решений", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        
        displayExperiments();
    }//GEN-LAST:event_jPanel1ComponentShown

    private void jPanel3ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel3ComponentShown
        
        jTable1.setVisible(false);
        displayefficiencyArray();
    }//GEN-LAST:event_jPanel3ComponentShown

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        
        displayRegionalStat();
    }//GEN-LAST:event_jPanel2ComponentShown

    private void jComboBoxConfigIndexPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxConfigIndexPropertyChange
    }//GEN-LAST:event_jComboBoxConfigIndexPropertyChange

    private void jComboBoxConfigIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConfigIndexActionPerformed
        
        displayRegionalStat();

        jPanel2.revalidate();
        jPanel2.repaint();

    }//GEN-LAST:event_jComboBoxConfigIndexActionPerformed

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jPanelGraphEfficientArray1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGraphEfficientArray1MouseMoved
        
        jPanelGraphEfficientArray1.setMouseX(evt.getX());
        jPanelGraphEfficientArray1.setMouseY(evt.getY());
        jPanelGraphEfficientArray1.revalidate();
        jPanelGraphEfficientArray1.repaint();
        
        
    }//GEN-LAST:event_jPanelGraphEfficientArray1MouseMoved

    private void jPanelGraphEfficientArray1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGraphEfficientArray1MouseClicked
        
        jPanelGraphEfficientArray1.setHighligt(-1);
        jPanelGraphEfficientArray1.repaint();
    }//GEN-LAST:event_jPanelGraphEfficientArray1MouseClicked

    private void jPanelGraphExperiments1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGraphExperiments1MouseMoved
        
        jPanelGraphExperiments1.setMouseX(evt.getX());
        jPanelGraphExperiments1.setMouseY(evt.getY());
        jPanelGraphExperiments1.revalidate();
        jPanelGraphExperiments1.repaint();
    }//GEN-LAST:event_jPanelGraphExperiments1MouseMoved

    private void jPanelGraphExperiments1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelGraphExperiments1MouseClicked
        
        jPanelGraphExperiments1.setHighligt(46);
        jPanelGraphExperiments1.repaint();
    }//GEN-LAST:event_jPanelGraphExperiments1MouseClicked

    private void jScrollBarEfficiencyYAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_jScrollBarEfficiencyYAdjustmentValueChanged
        
        jPanelGraphEfficientArray1.setyShift(jScrollBarEfficiencyY.getValue()*jSliderEfficiency.getValue()/2);
        jPanelGraphEfficientArray1.repaint();
    }//GEN-LAST:event_jScrollBarEfficiencyYAdjustmentValueChanged

    private void jScrollBarExperimentsYAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_jScrollBarExperimentsYAdjustmentValueChanged
        
        jPanelGraphExperiments1.setyShift(jScrollBarExperimentsY.getValue()*jSliderExperiments.getValue()/2);
        jPanelGraphExperiments1.repaint();
    }//GEN-LAST:event_jScrollBarExperimentsYAdjustmentValueChanged

    private void jScrollBarExperimentsXAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_jScrollBarExperimentsXAdjustmentValueChanged
        
        jPanelGraphExperiments1.setxShift(jScrollBarExperimentsX.getValue()*jSliderExperiments.getValue()/2);
        jPanelGraphExperiments1.repaint();
    }//GEN-LAST:event_jScrollBarExperimentsXAdjustmentValueChanged

    private void jScrollBarEfficiencyXAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_jScrollBarEfficiencyXAdjustmentValueChanged
        
        jPanelGraphEfficientArray1.setxShift(jScrollBarEfficiencyX.getValue()*jSliderEfficiency.getValue()/2);
        jPanelGraphEfficientArray1.repaint();
    }//GEN-LAST:event_jScrollBarEfficiencyXAdjustmentValueChanged

    private void displayExperiments(){



        jScrollBarExperimentsY.setMaximum(jSliderExperiments.getValue());
        jScrollBarExperimentsX.setMaximum(jSliderExperiments.getValue());
        List<Experiment> expList = experimentDAO.list();
        
        jTextField1.setText(Integer.toString(expList.size()));
        jTableExperiments.setModel(new ExperimentsTableModel(expList));
       
        this.jPanelGraphExperiments1.setExpList(expList);
        this.jPanelGraphExperiments1.revalidate();
        this.jPanelGraphExperiments1.repaint();

        jTableExperiments.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableExperiments.getColumnModel().getColumn(0).setWidth(50);
        jTableExperiments.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableExperiments.getColumnModel().getColumn(1).setWidth(50);
        jTableExperiments.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTableExperiments.getColumnModel().getColumn(2).setWidth(140);
        jTableExperiments.getColumnModel().getColumn(3).setPreferredWidth(140);
        jTableExperiments.getColumnModel().getColumn(3).setWidth(140);

        
        jTableExperiments.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            int row = jTableExperiments.getSelectedRow();
            int col = jTableExperiments.getSelectedColumn();
            jPanelGraphExperiments1.setHighligt(row);
            jPanelGraphExperiments1.revalidate();
            jPanelGraphExperiments1.repaint();
        }
        });
        
        jSliderExperiments.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                jPanelGraphExperiments1.setScale(jSliderExperiments.getValue());
                jScrollBarExperimentsY.setMinimum(0);
                jScrollBarExperimentsY.setMaximum(jSliderExperiments.getValue()+105);
                jScrollBarExperimentsY.setVisibleAmount(100-jSliderExperiments.getValue());
                jScrollBarExperimentsX.setMinimum(0);
                jScrollBarExperimentsX.setMaximum(jSliderExperiments.getValue()+105);
                jScrollBarExperimentsX.setVisibleAmount(100-jSliderExperiments.getValue());
                jPanelGraphExperiments1.repaint();
            }
        });
    
        
    }
    
    private void displayRegionalStat(){
        
        List<RegionalValues> rvList = regionalValuesDAO.getByConfigId(jComboBoxConfigIndex.getSelectedIndex()+1);

        NetworkConfig netConfig = networkConfigDAO.getById((jComboBoxConfigIndex.getSelectedIndex() + 1));
        ConfigParams confParams = configParamsDao.getById(netConfig.getParamsId());
        List<RegionLayer> regionList = regionLayerDao.list();

        jTextFieldCycleLength.setText(""+confParams.getCycle_length());
        jTextFieldReserveStorage.setText(String.format("%.3g%n",(confParams.getReserve_stock()*100)));
        int storageCount=0;

        
                
        String cities[] = new String[10];
        double shortage[] = new double[10];
        double supplied[] = new double[10];
        double degree[] = new double[10];
        double netWorkShortage=0.0,netWorkSupplied=0.0;
        for (int i = 0; i<10; i++){
            cities[i]=regionList.get(i).getAddressCity();
            supplied[i]=rvList.get(i).getRegion_supplied();
            if (supplied[i]!=0) storageCount++;
            shortage[i]=rvList.get(i).getRegion_shortage();
            degree[i]=1-shortage[i]/supplied[i];
            netWorkShortage+=shortage[i];
            netWorkSupplied+=supplied[i];
        }
        
        jTextFieldNetWorkDegree.setText(String.format("%.5g%n",(1-netWorkShortage/netWorkSupplied)*100));
        jTextFieldRegStorageCount.setText(""+storageCount);
        
        jTextFieldRegStorage1City.setText(cities[0]);
        if(supplied[0]!=0){
            jTextFieldRegStorage1Supplied.setText(String.format("%.5g%n", supplied[0]));
            jTextFieldRegStorage1Shortage.setText(String.format("%.5g%n", shortage[0]));
            jTextFieldRegStorage1Degree.setText(String.format("%.5g%n",degree[0]));
            jLabelRegStorage1Skipped1.setVisible(false);
            jTextFieldRegStorage1Supplied.setVisible(true);
            jTextFieldRegStorage1Shortage.setVisible(true);
            jTextFieldRegStorage1Degree.setVisible(true);
        } else {
            jTextFieldRegStorage1Supplied.setVisible(false);
            jTextFieldRegStorage1Shortage.setVisible(false);
            jTextFieldRegStorage1Degree.setVisible(false);
            jLabelRegStorage1Skipped1.setVisible(true);
        }
        
        jTextFieldRegStorage2City.setText(cities[1]);
        if(supplied[1]!=0){
            jTextFieldRegStorage2Supplied.setText(String.format("%.5g%n", supplied[1]));
            jTextFieldRegStorage2Shortage.setText(String.format("%.5g%n", shortage[1]));
            jTextFieldRegStorage2Degree.setText(String.format("%.5g%n",degree[1]));
            jLabelRegStorage2Skipped.setVisible(false);
            jTextFieldRegStorage2Supplied.setVisible(true);
            jTextFieldRegStorage2Shortage.setVisible(true);
            jTextFieldRegStorage2Degree.setVisible(true);
        } else {
            jTextFieldRegStorage2Supplied.setVisible(false);
            jTextFieldRegStorage2Shortage.setVisible(false);
            jTextFieldRegStorage2Degree.setVisible(false);
            jLabelRegStorage2Skipped.setVisible(true);
        }
        
         jTextFieldRegStorage3City.setText(cities[2]);
        if(supplied[2]!=0){
            jTextFieldRegStorage3Supplied.setText(String.format("%.5g%n", supplied[2]));
            jTextFieldRegStorage3Shortage.setText(String.format("%.5g%n", shortage[2]));
            jTextFieldRegStorage3Degree.setText(String.format("%.5g%n",degree[2]));
            jLabelRegStorage3Skipped.setVisible(false);
            jTextFieldRegStorage3Supplied.setVisible(true);
            jTextFieldRegStorage3Shortage.setVisible(true);
            jTextFieldRegStorage3Degree.setVisible(true);
        } else {
            jTextFieldRegStorage3Supplied.setVisible(false);
            jTextFieldRegStorage3Shortage.setVisible(false);
            jTextFieldRegStorage3Degree.setVisible(false);
            jLabelRegStorage3Skipped.setVisible(true);
        }
        
        jTextFieldRegStorage4City.setText(cities[3]);
        if(supplied[3]!=0){
            jTextFieldRegStorage4Supplied.setText(String.format("%.5g%n", supplied[3]));
            jTextFieldRegStorage4Shortage.setText(String.format("%.5g%n", shortage[3]));
            jTextFieldRegStorage4Degree.setText(String.format("%.5g%n",degree[3]));
            jLabelRegStorage4Skipped.setVisible(false);
            jTextFieldRegStorage4Supplied.setVisible(true);
            jTextFieldRegStorage4Shortage.setVisible(true);
            jTextFieldRegStorage4Degree.setVisible(true);
        } else {
            jTextFieldRegStorage4Supplied.setVisible(false);
            jTextFieldRegStorage4Shortage.setVisible(false);
            jTextFieldRegStorage4Degree.setVisible(false);
            jLabelRegStorage4Skipped.setVisible(true);
        }
        
        
        jTextFieldRegStorage5City.setText(cities[4]);
        if(supplied[4]!=0){
            jTextFieldRegStorage5Supplied.setText(String.format("%.5g%n", supplied[4]));
            jTextFieldRegStorage5Shortage.setText(String.format("%.5g%n", shortage[4]));
            jTextFieldRegStorage5Degree.setText(String.format("%.5g%n",degree[4]));
            jLabelRegStorage5Skipped.setVisible(false);
            jTextFieldRegStorage5Supplied.setVisible(true);
            jTextFieldRegStorage5Shortage.setVisible(true);
            jTextFieldRegStorage5Degree.setVisible(true);
        } else {
            jTextFieldRegStorage5Supplied.setVisible(false);
            jTextFieldRegStorage5Shortage.setVisible(false);
            jTextFieldRegStorage5Degree.setVisible(false);
            jLabelRegStorage5Skipped.setVisible(true);
        }
        
        
        jTextFieldRegStorage6City.setText(cities[5]);
        if(supplied[5]!=0){
            jTextFieldRegStorage6Supplied.setText(String.format("%.5g%n", supplied[5]));
            jTextFieldRegStorage6Shortage.setText(String.format("%.5g%n", shortage[5]));
            jTextFieldRegStorage6Degree.setText(String.format("%.5g%n",degree[5]));
            jLabelRegStorage6Skipped.setVisible(false);
            jTextFieldRegStorage6Supplied.setVisible(true);
            jTextFieldRegStorage6Shortage.setVisible(true);
            jTextFieldRegStorage6Degree.setVisible(true);
        } else {
            jTextFieldRegStorage6Supplied.setVisible(false);
            jTextFieldRegStorage6Shortage.setVisible(false);
            jTextFieldRegStorage6Degree.setVisible(false);
            jLabelRegStorage6Skipped.setVisible(true);
        }
        
        jTextFieldRegStorage7City.setText(cities[6]);
        if(supplied[6]!=0){
            jTextFieldRegStorage7Supplied.setText(String.format("%.5g%n", supplied[6]));
            jTextFieldRegStorage7Shortage.setText(String.format("%.5g%n", shortage[6]));
            jTextFieldRegStorage7Degree.setText(String.format("%.5g%n",degree[6]));
            jLabelRegStorage7Skipped.setVisible(false);
            jTextFieldRegStorage7Supplied.setVisible(true);
            jTextFieldRegStorage7Shortage.setVisible(true);
            jTextFieldRegStorage7Degree.setVisible(true);
        } else {
            jTextFieldRegStorage7Supplied.setVisible(false);
            jTextFieldRegStorage7Shortage.setVisible(false);
            jTextFieldRegStorage7Degree.setVisible(false);
            jLabelRegStorage7Skipped.setVisible(true);
        }
        
        jTextFieldRegStorage8City.setText(cities[7]);
        if(supplied[7]!=0){
            jTextFieldRegStorage8Supplied.setText(String.format("%.5g%n", supplied[7]));
            jTextFieldRegStorage8Shortage.setText(String.format("%.5g%n", shortage[7]));
            jTextFieldRegStorage8Degree.setText(String.format("%.5g%n",degree[7]));
            jLabelRegStorage8Skipped.setVisible(false);
            jTextFieldRegStorage8Supplied.setVisible(true);
            jTextFieldRegStorage8Shortage.setVisible(true);
            jTextFieldRegStorage8Degree.setVisible(true);
        } else {
            jTextFieldRegStorage8Supplied.setVisible(false);
            jTextFieldRegStorage8Shortage.setVisible(false);
            jTextFieldRegStorage8Degree.setVisible(false);
            jLabelRegStorage8Skipped.setVisible(true);
        }
        
        jTextFieldRegStorage9City.setText(cities[8]);
        if(supplied[8]!=0){
            jTextFieldRegStorage9Supplied.setText(String.format("%.5g%n", supplied[8]));
            jTextFieldRegStorage9Shortage.setText(String.format("%.5g%n", shortage[8]));
            jTextFieldRegStorage9Degree.setText(String.format("%.5g%n",degree[8]));
            jLabelRegStorage9Skipped.setVisible(false);
            jTextFieldRegStorage9Supplied.setVisible(true);
            jTextFieldRegStorage9Shortage.setVisible(true);
            jTextFieldRegStorage9Degree.setVisible(true);
        } else {
            jTextFieldRegStorage9Supplied.setVisible(false);
            jTextFieldRegStorage9Shortage.setVisible(false);
            jTextFieldRegStorage9Degree.setVisible(false);
            jLabelRegStorage9Skipped.setVisible(true);
        }
        
        
        jTextFieldRegStorage10City.setText(cities[9]);
        if(supplied[9]!=0){
            jTextFieldRegStorage10Supplied.setText(String.format("%.5g%n", supplied[9]));
            jTextFieldRegStorage10Shortage.setText(String.format("%.5g%n", shortage[9]));
            jTextFieldRegStorage10Degree.setText(String.format("%.5g%n",degree[9]));
            jLabelRegStorage10Skipped.setVisible(false);
            jTextFieldRegStorage10Supplied.setVisible(true);
            jTextFieldRegStorage10Shortage.setVisible(true);
            jTextFieldRegStorage10Degree.setVisible(true);
        } else {
            jTextFieldRegStorage10Supplied.setVisible(false);
            jTextFieldRegStorage10Shortage.setVisible(false);
            jTextFieldRegStorage10Degree.setVisible(false);
            jLabelRegStorage10Skipped.setVisible(true);
        }
    }
     
    
    private void displayefficiencyArray(){
        
        jScrollBarEfficiencyX.setMaximum(jSliderExperiments.getValue());
        jScrollBarEfficiencyY.setMaximum(jSliderExperiments.getValue());
        
        List<NetworkConfig> configList = networkConfigDAO.list();

        double serviceDegree[] = new double[45];
        double networkShortage[] = new double[45];
        double networkSUpplied[] = new double[45];
        
        
        for (int i = 0; i<configList.size(); i++){

            List<RegionalValues> rvList = regionalValuesDAO.getByConfigId(i + 1);

            for (int j = 0; j<rvList.size(); j++){
                    networkSUpplied[i]+=rvList.get(j).getRegion_supplied();
                    networkShortage[i]+=rvList.get(j).getRegion_shortage();
            }
            serviceDegree[i]=1-networkShortage[i]/networkSUpplied[i];

        }
        
        jTable1.setModel(new EfficiencyTableModel(configList, serviceDegree));
        jTable1.setVisible(true);
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(0).setWidth(50);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setWidth(100);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTable1.getColumnModel().getColumn(2).setWidth(140);

         
        jPanelGraphEfficientArray1.setNetworkDegree(serviceDegree);
        jPanelGraphEfficientArray1.setnConfigList(configList);
        jPanelGraphEfficientArray1.revalidate();
        jPanelGraphEfficientArray1.repaint();
        
        jTable1.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            int row = jTable1.getSelectedRow();
            int col = jTable1.getSelectedColumn();
            jPanelGraphEfficientArray1.setHighligt(row);
            jPanelGraphEfficientArray1.revalidate();
            jPanelGraphEfficientArray1.repaint();
        }
        });
        
        jSliderEfficiency.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                jPanelGraphEfficientArray1.setScale(jSliderEfficiency.getValue());
                jPanelGraphEfficientArray1.repaint();
            }
        });
        
        jSliderEfficiency.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent e) {
                jPanelGraphExperiments1.setScale(jSliderEfficiency.getValue());
                jScrollBarEfficiencyY.setMinimum(0);
                jScrollBarEfficiencyY.setMaximum(jSliderEfficiency.getValue()+105);
                jScrollBarEfficiencyY.setVisibleAmount(100-jSliderEfficiency.getValue());
                jScrollBarEfficiencyX.setMinimum(0);
                jScrollBarEfficiencyX.setMaximum(jSliderEfficiency.getValue()+105);
                jScrollBarEfficiencyX.setVisibleAmount(100-jSliderEfficiency.getValue());
                jScrollBarEfficiencyX.repaint();
            }
        });
    }

}
