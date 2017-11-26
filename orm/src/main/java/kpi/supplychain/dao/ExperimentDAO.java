package kpi.supplychain.dao;

import kpi.supplychain.pojo.Experiment;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository(value = "experimentDao")
public class ExperimentDAO extends DAO<Experiment, Integer> {

    public Serializable save(Experiment o) {
        return super.generalCreate(o);
    }

    public void update(Experiment o) {
        super.generalUpdate(o);
    }

    public void delete(Experiment o) {
        super.generalRemove(o);
    }

    public List<Experiment> list() {
        return super.list(Experiment.class);
    }

    public Experiment selectById(Integer key) {
        return super.selectById(Experiment.class, key);
    }

    public List<Experiment> selectByField(String fieldName, String fieldValue) {
        return super.selectByField(Experiment.class, fieldName, fieldValue);
    }
}
