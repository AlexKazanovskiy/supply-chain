package kpi.supplychain.dao;

import kpi.supplychain.pojo.ConfigParams;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository(value = "configParamsDao")
public class ConfigParamsDao extends DAO<ConfigParams, Integer> {
    public Serializable save(ConfigParams o) {
        return super.generalCreate(o);
    }

    public void update(ConfigParams o) {
        super.generalUpdate(o);
    }

    public void delete(ConfigParams o) {
        super.generalRemove(o);
    }

    public List<ConfigParams> list() {
        return super.list(ConfigParams.class);
    }

    public ConfigParams getById(Integer key) {
        return super.selectById(ConfigParams.class, key);
    }

    public ConfigParams getByUniqueField(String fieldName, String fieldValue) {
        return super.selectByUniqueField(ConfigParams.class, fieldName, fieldValue);
    }
}
