package kpi.supplychain.dao.configuration;

import kpi.supplychain.dao.DAO;
import kpi.supplychain.pojo.configuration.NationalLayer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "nationalLayerDao")
public class NationalLayerDao extends DAO<NationalLayer, Integer> {
    public Integer save(NationalLayer o) {
        return (Integer) super.generalCreate(o);
    }

    public void update(NationalLayer o) {
        super.generalUpdate(o);
    }

    public void delete(NationalLayer o) {
        super.generalRemove(o);
    }

    public List<NationalLayer> list() {
        return super.list(NationalLayer.class);
    }

    public NationalLayer selectById(Integer key) {
        return super.selectById(NationalLayer.class, key);
    }

    public List<NationalLayer> selectByField(String fieldName, String fieldValue) {
        return super.selectByField(NationalLayer.class, fieldName, fieldValue);
    }
}
