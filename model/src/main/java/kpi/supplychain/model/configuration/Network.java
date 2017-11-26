package kpi.supplychain.model.configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Network extends Observable {
    private int[][] data;
    private int[] y;
    private double reserveCoef = 1;
    private LocalWarehouse[] local;
    private Warehouse[] regional;
    private Warehouse[] national;
    private Warehouse[] producer;
    private double localTransportCost;
    private double regionTransportCost;
    private double regionWarehouseCost;
    private double natonalWarehouseCost;

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        System.out.println("Add observer " + new Date().getTime());
    }

    @Override
    public void notifyObservers() {
        super.setChanged();
        super.notifyObservers();
        System.out.println("Notify observer " + new Date().getTime());
    }

    public void writeDataForSimulationModel(int week) throws IOException {
        FileWriter fstream = new FileWriter("d:\\im\\demands.txt");
        BufferedWriter out = new BufferedWriter(fstream);
        for (Warehouse warehouse : getRegional()) {
            out.write(warehouse.getVolumes()[0] / week + "\n");
            out.write(warehouse.getVolumes()[1] / week + "\n");
            out.write(warehouse.getVolumes()[2] / week + "\n");

            out.write(warehouse.getReserve()[0] / Math.sqrt(week) + "\n");
            out.write(warehouse.getReserve()[1] / Math.sqrt(week) + "\n");
            out.write(warehouse.getReserve()[2] / Math.sqrt(week) + "\n");
        }
        out.close();

        fstream = new FileWriter("d:\\im\\rop.txt");
        out = new BufferedWriter(fstream);
        for (Warehouse warehouse : getRegional()) {
            out.write(warehouse.getVolumes()[0] + getReserveCoef() * warehouse.getReserve()[0] + "\n");
            out.write(warehouse.getVolumes()[1] + getReserveCoef() * warehouse.getReserve()[1] + "\n");
            out.write(warehouse.getVolumes()[2] + getReserveCoef() * warehouse.getReserve()[2] + "\n");
        }
        out.close();

        fstream = new FileWriter("d:\\im\\rop_national.txt");
        out = new BufferedWriter(fstream);
        for (Warehouse warehouse : getNational()) {
            out.write(warehouse.getVolumes()[0] + 0.5 * getReserveCoef() * warehouse.getReserve()[0] + "\n");
            out.write(warehouse.getVolumes()[1] + 0.5 * getReserveCoef() * warehouse.getReserve()[1] + "\n");
            out.write(warehouse.getVolumes()[2] + 0.5 * getReserveCoef() * warehouse.getReserve()[2] + "\n");
        }
        out.close();

        fstream = new FileWriter("d:\\im\\partition.txt");
        out = new BufferedWriter(fstream);
        out.write(week * 7 + "\n");
        for (Warehouse warehouse : getRegional()) {

            Route route = warehouse.getRoutes().get(0);
            if (route == null) {
                out.write("0.0" + "\n");
                out.write("0.0" + "\n");
                out.write("0.0" + "\n");
            } else {
                out.write(route.getVolumes()[0] / warehouse.getVolumes()[0] + "\n");
                out.write(route.getVolumes()[1] / warehouse.getVolumes()[1] + "\n");
                out.write(route.getVolumes()[2] / warehouse.getVolumes()[2] + "\n");
            }
        }
        out.close();
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int getProducerCount() {
        return producer.length;
    }

    public int getNationalCount() {
        return national.length;
    }

    public int getRegionalCount() {
        return regional.length;
    }

    public int getLocalCount() {
        return local.length;
    }

    public double getReserveCoef() {
        return reserveCoef;
    }

    public void setReserveCoef(double reserveCoef) {
        this.reserveCoef = reserveCoef;
    }

    public LocalWarehouse[] getLocal() {
        return local;
    }

    public void setLocal(LocalWarehouse[] local) {
        this.local = local;
    }

    public Warehouse[] getRegional() {
        return regional;
    }

    public void setRegional(Warehouse[] regional) {
        this.regional = regional;
    }

    public Warehouse[] getNational() {
        return national;
    }

    public void setNational(Warehouse[] national) {
        this.national = national;
    }

    public Warehouse[] getProducer() {
        return producer;
    }

    public void setProducer(Warehouse[] producer) {
        this.producer = producer;
    }

    public double getLocalTransportCost() {
        return localTransportCost;
    }

    public void setLocalTransportCost(double localTransportCost) {
        this.localTransportCost = localTransportCost;
    }

    public double getRegionTransportCost() {
        return regionTransportCost;
    }

    public void setRegionTransportCost(double regionTransportCost) {
        this.regionTransportCost = regionTransportCost;
    }

    public double getRegionWarehouseCost() {
        return regionWarehouseCost;
    }

    public void setRegionWarehouseCost(double regionWarehouseCost) {
        this.regionWarehouseCost = regionWarehouseCost;
    }

    public double getNatonalWarehouseCost() {
        return natonalWarehouseCost;
    }

    public void setNatonalWarehouseCost(double natonalWarehouseCost) {
        this.natonalWarehouseCost = natonalWarehouseCost;
    }
}
