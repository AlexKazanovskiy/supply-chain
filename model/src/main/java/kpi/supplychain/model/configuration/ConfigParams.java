package kpi.supplychain.model.configuration;

/**
 * Created by I on 16.06.2015.
 */
public class ConfigParams {

    private int regionalWarehouseCount;
    private int shipmentCycleLength;
    private int reserveStockAmount;
    private Network network;

    public int getRegionalWarehouseCount() {
        return regionalWarehouseCount;
    }

    public void setRegionalWarehouseCount(int regionalWarehouseCount) {
        this.regionalWarehouseCount = regionalWarehouseCount;
    }

    public int getShipmentCycleLength() {
        return shipmentCycleLength;
    }

    public void setShipmentCycleLength(int shipmentCycleLength) {
        this.shipmentCycleLength = shipmentCycleLength;
    }

    public int getReserveStockAmount() {
        return reserveStockAmount;
    }

    public void setReserveStockAmount(int reserveStockAmount) {
        this.reserveStockAmount = reserveStockAmount;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
}
