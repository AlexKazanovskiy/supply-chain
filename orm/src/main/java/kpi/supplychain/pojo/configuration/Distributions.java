package kpi.supplychain.pojo.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distributions")
public class Distributions {

    @Id
    @Column(name = "id_distribution")
    private String id;

    @Column(name = "id_region")
    private int region;

    @Column(name = "id_product")
    private int product;

    @Column(name = "expected_value")
    private double expected_value;

    @Column(name = "standard_deviation")
    private double standard_deviation;

    public Distributions() {
    }

    public String getId() {
        return id;
    }

    public void setId(String tableid) {
        this.id = tableid;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public double getExpected_value() {
        return expected_value;
    }

    public void setExpected_value(double expected_value) {
        this.expected_value = expected_value;
    }

    public double getStandard_deviation() {
        return standard_deviation;
    }

    public void setStandard_deviation(double standard_deviation) {
        this.standard_deviation = standard_deviation;
    }
}
