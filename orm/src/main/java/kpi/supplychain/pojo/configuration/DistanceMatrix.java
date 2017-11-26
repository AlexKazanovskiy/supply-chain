package kpi.supplychain.pojo.configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distancematrix")
public class DistanceMatrix {

    @Id
    @Column(name = "id_distance")
    private String id;

    @Column(name = "id_local")
    private int originals;

    @Column(name = "id_region")
    private int destination;

    @Column(name = "value")
    private int distance;

    public DistanceMatrix() {
    }

    public String getId() {
        return id;
    }

    public void setId(String tableid) {
        this.id = tableid;
    }

    public int getOriginals() {
        return originals;
    }

    public void setOriginals(int originals) {
        this.originals = originals;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
