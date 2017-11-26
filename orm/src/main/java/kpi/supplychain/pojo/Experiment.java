package kpi.supplychain.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "experiment")
public class Experiment extends POJO{

    @Id
    @Column(name = "experiment_id")
    private int id;

    @Column(name = "config_id")
    private int config_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "service_degree")
    private double service_degree;

    public int getId() {
        return id;
    }

    public void setId(int experiment_id) {
        this.id = experiment_id;
    }

    public int getConfig_id() {
        return config_id;
    }

    public void setConfig_id(int config_id) {
        this.config_id = config_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getService_degree() {
        return service_degree;
    }

    public void setService_degree(double service_degree) {
        this.service_degree = service_degree;
    }

    @Override
    public String toString() {
        return "ExperimentPOJO{" + "experiment_id=" + id + ", config_id=" + config_id + ", date=" + date + ", service_degree=" + service_degree + '}';
    }
}
