package kpi.supplychain.dao.configuration;


import kpi.supplychain.dao.DAO;
import kpi.supplychain.pojo.configuration.RegionalValues;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author I
 */
@Repository(value = "regionalValuesDAO")
public class RegionalValuesDao extends DAO<RegionalValues, Integer> {
    public Serializable save(RegionalValues o) {
        return super.generalCreate(o);
    }

    public void update(RegionalValues o) {
        super.generalUpdate(o);
    }

    public void delete(RegionalValues o) {
        super.generalRemove(o);
    }

    public List<RegionalValues> list() {
        return super.list(RegionalValues.class);
    }

    public RegionalValues getById(Integer key) {
        return super.selectById(RegionalValues.class, key);
    }

    public RegionalValues getByUniqueField(String fieldName, String fieldValue) {
        return super.selectByUniqueField(RegionalValues.class, fieldName, fieldValue);
    }

    public List<RegionalValues> getByConfigId(int configId) {
        return super.selectByField(RegionalValues.class, "config_id", configId);
    }
}
