package kpi.supplychain.pojo;

import javax.persistence.*;

@Entity
@Table(name = "network_config")
public class NetworkConfig {

    @Id
    @GeneratedValue
    @Column(name = "id_network_config")
    private int id;

    @Column(name = "id_params")
    private int paramsId;

    @Column(name = "total_cost")
    private double totalCost;
 
    public int getId() {
        return id;
    }

    public void setId(int config_id) {
        this.id = config_id;
    }

    public int getParamsId() {
        return paramsId;
    }

    public void setParamsId(int params_id) {
        this.paramsId = params_id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
