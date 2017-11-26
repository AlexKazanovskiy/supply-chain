package kpi.supplychain.model.configuration;

import kpi.supplychain.model.Constants;

public class Route {
    private int warehouse_id;
    private int[] truck = new int[Constants.COUNT_TRANSPORT];
    private double[] volumes = new double[Constants.COUNT_PRODUCT];
    private int km;
    private int times;

    public Route(int id) {
        this.setWarehouse_id(id);
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public int[] getTruck() {
        return truck;
    }

    public void setTruck(int[] truck) {
        this.truck = truck;
    }

    public double[] getVolumes() {
        return volumes;
    }

    public void setVolumes(double[] volumes) {
        this.volumes = volumes;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
