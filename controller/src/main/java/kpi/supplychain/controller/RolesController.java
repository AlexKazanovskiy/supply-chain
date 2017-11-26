package kpi.supplychain.controller;

import kpi.supplychain.pojo.Role;
import kpi.supplychain.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RESTful controller for Roles.
 */
@RestController
@RequestMapping(value = "roles")
public class RolesController {

    /**
     * Service.
     */
    @Autowired
    private RoleService roleService;


    /**
     * Retrieves a list of roles.
     * @return list of roles.
     */
    @RequestMapping(
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<Role> getRoles() {
        return roleService.getRoles();
    }

    /**
     * Retrieves role by name.
     * @param name name of the role
     * @return role object
     */
    @RequestMapping(
            value = "/{name}",
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final Role getByName(@PathVariable final String name) {
        return roleService.findByName(name);
    }
}
