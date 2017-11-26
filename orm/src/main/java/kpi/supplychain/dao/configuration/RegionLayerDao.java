package kpi.supplychain.dao.configuration;

import kpi.supplychain.dao.DAO;
import kpi.supplychain.pojo.configuration.RegionLayer;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository(value = "regionLayerDao")
public class RegionLayerDao extends DAO<RegionLayer, String> {
    public Serializable save(RegionLayer o) {
        return super.generalCreate(o);
    }

    public void update(RegionLayer o) {
        super.generalUpdate(o);
    }

    public void delete(RegionLayer o) {
        super.generalRemove(o);
    }

    public List<RegionLayer> list() {
        return super.list(RegionLayer.class);
    }

    public RegionLayer getById(String key) {
        return super.selectById(RegionLayer.class, key);
    }

    public RegionLayer getByUniqueField(String fieldName, String fieldValue) {
        return super.selectByUniqueField(RegionLayer.class, fieldName, fieldValue);
    }
}
