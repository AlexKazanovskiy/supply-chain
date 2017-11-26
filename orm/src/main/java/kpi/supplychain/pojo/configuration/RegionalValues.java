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
@Table(name = "regional_values")
public class RegionalValues {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "config_id")
    private int config_id;

    @Column(name = "region_id")
    private int region_id;

    @Column(name = "region_shortage")
    private double region_shortage;

    @Column(name = "region_supplied")
    private double region_supplied;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConfig_id() {
        return config_id;
    }

    public void setConfig_id(int config_id) {
        this.config_id = config_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public double getRegion_shortage() {
        return region_shortage;
    }

    public void setRegion_shortage(double region_shortage) {
        this.region_shortage = region_shortage;
    }

    public double getRegion_supplied() {
        return region_supplied;
    }

    public void setRegion_supplied(double region_supplied) {
        this.region_supplied = region_supplied;
    }
}
