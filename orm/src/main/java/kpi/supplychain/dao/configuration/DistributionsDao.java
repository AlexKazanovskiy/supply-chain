package kpi.supplychain.dao.configuration;

import kpi.supplychain.dao.DAO;
import kpi.supplychain.pojo.configuration.Distributions;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stryzhov.
 */
@Repository(value = "distributionsDao")
public class DistributionsDao extends DAO<Distributions, String> {

    public Serializable save(Distributions o) {
        return super.generalCreate(o);
    }

    public void update(Distributions o) {
        super.generalUpdate(o);
    }

    public void delete(Distributions o) {
        super.generalRemove(o);
    }

    public List<Distributions> list() {
        return super.list(Distributions.class);
    }

    public Distributions selectById(String key) {
        return super.selectById(Distributions.class, key);
    }

    public List<Distributions> selectByField(String fieldName, String fieldValue) {
        return super.selectByField(Distributions.class, fieldName, fieldValue);
    }
}
