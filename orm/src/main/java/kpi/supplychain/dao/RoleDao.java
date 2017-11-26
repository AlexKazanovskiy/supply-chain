package kpi.supplychain.dao;

import kpi.supplychain.pojo.Role;
import kpi.supplychain.pojo.Role;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository(value = "roleDao")
public class RoleDao extends DAO<Role, Long> {

    public Serializable save(Role o) {
        return super.generalCreate(o);
    }

    public void update(Role o) {
        super.generalUpdate(o);
    }

    public void delete(Role o) {
        super.generalRemove(o);
    }

    public List<Role> list() {
        return super.list(Role.class);
    }

    public Role getById(Long key) {
        return super.selectById(Role.class, key);
    }

    public Role getByUniqueField(String fieldName, String fieldValue) {
        return super.selectByUniqueField(Role.class, fieldName, fieldValue);
    }
}
