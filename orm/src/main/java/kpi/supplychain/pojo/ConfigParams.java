/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kpi.supplychain.pojo;

import javax.persistence.*;

@Entity
@Table(name = "config_params")
public class ConfigParams {

    @Id
    @GeneratedValue
    @Column(name = "id_config_params")
    private int id;

    @Column(name = "cycle_length")
    private int cycle_length;

    @Column(name = "reserve_stock")
    private double reserve_stock;

    public int getId() {
        return id;
    }

    public void setId(int params_id) {
        this.id = params_id;
    }

    public int getCycle_length() {
        return cycle_length;
    }

    public void setCycle_length(int cycle_length) {
        this.cycle_length = cycle_length;
    }

    public double getReserve_stock() {
        return reserve_stock;
    }

    public void setReserve_stock(double reserve_stock) {
        this.reserve_stock = reserve_stock;
    }
}
