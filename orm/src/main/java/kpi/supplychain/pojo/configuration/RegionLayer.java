/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kpi.supplychain.pojo.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regionlayer")
public class RegionLayer {

    @Id
    @Column(name = "tableid")
    private String id;

    @Column(name = "id_region")
    private int regionId;

    @Column(name = "region_name")
    private String addressCity;

    public RegionLayer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String tableid) {
        this.id = tableid;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int id) {
        this.regionId = id;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
}
