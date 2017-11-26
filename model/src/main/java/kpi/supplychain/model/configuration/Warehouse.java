package kpi.supplychain.model.configuration;

import kpi.supplychain.model.Constants;

import java.util.Map;
import java.util.TreeMap;


public class Warehouse {
    private int id;
    private String adress;
    private double[] volumes = new double[Constants.COUNT_PRODUCT];
    private double[] reserve = new double[Constants.COUNT_PRODUCT];
    private Map<Integer, Route> routes = new TreeMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double[] getVolumes() {
        return volumes;
    }

    public void setVolumes(double[] volumes) {
        this.volumes = volumes;
    }

    public double[] getReserve() {
        return reserve;
    }

    public void setReserve(double[] reserve) {
        this.reserve = reserve;
    }

    public Map<Integer, Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<Integer, Route> routes) {
        this.routes = routes;
    }
}
