package kpi.supplychain.service;

import kpi.supplychain.dao.RoleDao;
import kpi.supplychain.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic for the Role table.
 */
@Service("RoleService")
public class RoleService {

    /**
     * DAO.
     */
    @Autowired
    private RoleDao roleDao;

    /**
     * Retrieves list of roles.
     * @return list.
     */
    public final List<Role> getRoles() {
        return roleDao.list();
    }

    /**
     * Retrieves role by specified name.
     * @param roleName name of the role.
     * @return Role object.
     */
    public final Role findByName(final String roleName) {
        return roleDao.getByUniqueField("name", roleName);
    }
}
