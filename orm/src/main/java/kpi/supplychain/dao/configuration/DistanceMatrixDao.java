package kpi.supplychain.dao.configuration;

import kpi.supplychain.dao.DAO;
import kpi.supplychain.pojo.configuration.DistanceMatrix;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stryzhov.
 */
@Repository(value = "distanceMatrixDao")
public class DistanceMatrixDao extends DAO<DistanceMatrix, String> {
    public Serializable save(DistanceMatrix o) {
        return super.generalCreate(o);
    }

    public void update(DistanceMatrix o) {
        super.generalUpdate(o);
    }

    public void delete(DistanceMatrix o) {
        super.generalRemove(o);
    }

    public List<DistanceMatrix> list() {
        return super.list(DistanceMatrix.class);
    }

    public DistanceMatrix selectById(String key) {
        return super.selectById(DistanceMatrix.class, key);
    }

    public List<DistanceMatrix> selectByField(String fieldName, String fieldValue) {
        return super.selectByField(DistanceMatrix.class, fieldName, fieldValue);
    }
}
