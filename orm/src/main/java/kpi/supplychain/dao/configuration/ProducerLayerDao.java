package kpi.supplychain.dao.configuration;

import kpi.supplychain.dao.DAO;
import kpi.supplychain.pojo.configuration.ProducerLayer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "producerLayerDao")
public class ProducerLayerDao extends DAO<ProducerLayer, Integer> {
    public Integer save(ProducerLayer o) {
        return (Integer) super.generalCreate(o);
    }

    public void update(ProducerLayer o) {
        super.generalUpdate(o);
    }

    public void delete(ProducerLayer o) {
        super.generalRemove(o);
    }

    public List<ProducerLayer> list() {
        return super.list(ProducerLayer.class);
    }

    public ProducerLayer getById(Integer key) {
        return super.selectById(ProducerLayer.class, key);
    }

    public ProducerLayer getByUniqueField(String fieldName, String fieldValue) {
        return super.selectByUniqueField(ProducerLayer.class, fieldName, fieldValue);
    }
}
