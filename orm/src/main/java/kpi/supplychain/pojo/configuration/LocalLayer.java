package kpi.supplychain.pojo.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locallayer")
public class LocalLayer {

    @Id
    @Column(name = "tableid")
    private String tableId;

    @Column(name = "id_local")
    private int id;

    @Column(name = "local_name")
    private String addressCity;

    @Column(name = "id_region")
    private int regionKey;

    public LocalLayer() {
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableid) {
        this.tableId = tableid;
    }

    public int getId() {
        return id;
    }

    public void setId(int idlocal) {
        this.id = idlocal;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public int getRegionKey() {
        return regionKey;
    }

    public void setRegionKey(int regionKey) {
        this.regionKey = regionKey;
    }
}
