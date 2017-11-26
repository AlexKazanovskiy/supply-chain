package kpi.supplychain.dao.configuration;

import kpi.supplychain.dao.DAO;
import kpi.supplychain.pojo.configuration.LocalLayer;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stryzhov.
 */
@Repository(value = "localLayerDao")
public class LocalLayerDao extends DAO<LocalLayer, String> {

    public Serializable save(LocalLayer o) {
        return super.generalCreate(o);
    }

    public void update(LocalLayer o) {
        super.generalUpdate(o);
    }

    public void delete(LocalLayer o) {
        super.generalRemove(o);
    }

    public List<LocalLayer> list() {
        return super.list(LocalLayer.class);
    }

    public LocalLayer selectById(String key) {
        return super.selectById(LocalLayer.class, key);
    }

    public List<LocalLayer> selectByField(String fieldName, String fieldValue) {
        return super.selectByField(LocalLayer.class, fieldName, fieldValue);
    }
}
