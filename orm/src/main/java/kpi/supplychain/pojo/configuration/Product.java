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
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id_product")
    private String id;

    @Column(name = "product_name")
    private String name;

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String tableid) {
        this.id = tableid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
