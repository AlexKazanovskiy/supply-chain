package kpi.supplychain.dao;

import kpi.supplychain.pojo.NetworkConfig;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository(value = "networkConfigDAO")
public class NetworkConfigDAO extends DAO<NetworkConfig, Integer> {
    public Serializable save(NetworkConfig o) {
        return super.generalCreate(o);
    }

    public void update(NetworkConfig o) {
        super.generalUpdate(o);
    }

    public void delete(NetworkConfig o) {
        super.generalRemove(o);
    }

    public List<NetworkConfig> list() {
        return super.list(NetworkConfig.class);
    }

    public NetworkConfig getById(Integer key) {
        return super.selectById(NetworkConfig.class, key);
    }

    public NetworkConfig getByUniqueField(String fieldName, String fieldValue) {
        return super.selectByUniqueField(NetworkConfig.class, fieldName, fieldValue);
    }
}
