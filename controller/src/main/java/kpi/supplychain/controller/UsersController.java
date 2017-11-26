package kpi.supplychain.controller;

import kpi.supplychain.pojo.User;
import kpi.supplychain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * RESTful controller for users.
 */
@Controller
@RequestMapping("users")
public class UsersController {

    /**
     * Service.
     */
    @Autowired
    private UserService userService;

    /**
     * Retrieves list of users.
     * @return list of users.
     */
    @RequestMapping(
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Retrieves user by ID.
     * @param id ID of user.
     * @return user object.
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public final User getById(@PathVariable final Long id) {
        return userService.findById(id);
    }

    /**
     * Updates user.
     * @param id ID of user to be updated
     * @param user new user object.
     * @param bindingResult binding result.
     * @throws BindException if binding errors are present.
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public final void updateUser(
                      @PathVariable final Long id,
                      @RequestBody @Valid final User user,
                      BindingResult bindingResult)
            throws BindException {
        checkUniqueFields(user, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        userService.updateUser(user);
    }

    /**
     * Deletes user.
     * @param id ID of user to be deleted.
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public final void deleteUser(@PathVariable final Long id,
                                 HttpServletRequest request) throws Exception {
        User loggedUser = userService.
                findByLogin(request.getUserPrincipal().getName());
        if(loggedUser.getId().equals(id)) {
            throw new Exception("You can't delete yourself");
        } else {
            userService.removeUser(id);
        }
    }

    /**
     * Creates user.
     * @param user new user object.
     * @param bindingResult binding result.
     * @throws BindException if binding errors are present
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public final User createUser(
                      @RequestBody @Valid final User user,
                      BindingResult bindingResult)
            throws BindException {
        checkUniqueFields(user, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        return userService.addUser(user);
    }

    /**
     * Checks unique fields on user object.
     * @param user user object.
     * @param bindingResult binding result.
     */
    private void checkUniqueFields(
                 final User user,
                 BindingResult bindingResult) {
        if (!userService.checkLoginUnique(user)) {
            bindingResult.rejectValue(
                    "login",
                    "error",
                    "Login already taken!");
        }
        if (!userService.checkEmailUnique(user)) {
            bindingResult.rejectValue(
                    "email",
                    "error",
                    "Email already taken!");
        }
    }

    /**
     * Handling BindException.
     * @param e BindException object.
     * @return Response entity.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final JsonExceptionInformation exceptionHandler(
            HttpServletRequest request, Exception e) {
        String message;
        if (e instanceof BindException) {
            List<ObjectError> allErrors = ((BindException) e).getAllErrors();
            StringBuilder sb = new StringBuilder();
            for (ObjectError error : allErrors) {
                sb
                        .append(error.getDefaultMessage())
                        .append(System.getProperty("line.separator"));
            }
            message = sb.toString();
        } else {
            message = e.getMessage();
        }

        JsonExceptionInformation information = new JsonExceptionInformation();
        information.setUrl(request.getRequestURL().toString());
        information.setMethod(request.getMethod());
        information.setException(e.getClass().getName());
        information.setMessage(message);
        return information;
    }
}
