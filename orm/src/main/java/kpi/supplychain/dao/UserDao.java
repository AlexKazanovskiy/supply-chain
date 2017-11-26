package kpi.supplychain.dao;
import kpi.supplychain.pojo.User;
import kpi.supplychain.pojo.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


/**
 * User dao.
 */
@Repository(value = "userDao")
public class UserDao extends DAO<User, Long> {

    public Serializable save(User o) {
        return super.generalCreate(o);
    }

    public void update(User o) {
        super.generalUpdate(o);
    }

    public void delete(User o) {
        super.generalRemove(o);
    }

    public List<User> list() {
        return super.list(User.class);
    }

    public User getById(Long key) {
        return super.selectById(User.class, key);
    }

    public User getByUniqueField(String fieldName, String fieldValue) {
        return super.selectByUniqueField(User.class, fieldName, fieldValue);
    }
}
