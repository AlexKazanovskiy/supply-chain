package kpi.supplychain.gui.configuration;


import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.model.configuration.Warehouse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GraphFrame extends JPanel implements Observer {

    private Point[] producer;
    private Point[] national;
    private Point[] regional;
    private Network network;
    private static final long serialVersionUID = 1L;

    public GraphFrame() {
        super();
    }

    public void init() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        network.addObserver(this);
        producer = new Point[network.getProducerCount()];
        national = new Point[network.getNationalCount()];
        regional = new Point[network.getRegionalCount()];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int height = getHeight();
        int width = getWidth();

        int levelWidth = width / 3;

        g.drawString("Производственный уровень", (int) (0.5 * levelWidth) - 50, 15);
        g.drawString("Национальный уровень", (int) (1.5 * levelWidth) - 50, 15);
        g.drawString("Региональный уровень", (int) (2.5 * levelWidth) - 50, 15);

        int[] routeCount = new int[10];

        for (Warehouse local : network.getLocal()) {
            for (int i = 0; i < routeCount.length; i++) {
                if (local.getRoutes().containsKey(i)) {
                    routeCount[i]++;
                }
            }
        }

        int rowHeight = height / producer.length;
        for (int j = 0; j < producer.length; j++) {
            producer[j] = new Point((int) (0.5 * levelWidth), (int) ((j + 0.5) * rowHeight));
            g.drawOval(producer[j].x, producer[j].y, 3, 3);
            g.drawString(network.getProducer()[j].getAdress(), producer[j].x - 20, producer[j].y - 5);
        }

        rowHeight = height / national.length;
        for (int j = 0; j < national.length; j++) {
            national[j] = new Point((int) (1.5 * levelWidth), (int) ((j + 0.5) * rowHeight));
            g.drawOval(national[j].x, national[j].y, 3, 3);
            g.drawString(network.getNational()[j].getAdress(), national[j].x - 20, national[j].y - 5);
        }

        rowHeight = height / regional.length;
        for (int j = 0; j < regional.length; j++) {
            regional[j] = new Point((int) (2.5 * levelWidth), (int) ((j + 0.5) * rowHeight));
            g.drawOval(regional[j].x, regional[j].y, 3, 3);
            g.drawString(network.getRegional()[j].getAdress() + " - " + routeCount[j], regional[j].x + 5, regional[j].y + 5);
        }

        for (int i = 0; i < national.length; i++) {
            for (Integer key : network.getNational()[i].getRoutes().keySet()) {
                g.drawLine(national[i].x, national[i].y, producer[key].x, producer[key].y);
            }
        }

        for (int i = 0; i < regional.length; i++) {
            for (Integer key : network.getRegional()[i].getRoutes().keySet()) {
                g.drawLine(regional[i].x, regional[i].y, national[key].x, national[key].y);
            }
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Graph repaint " + new Date().getTime());
        this.repaint();
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
