package kpi.supplychain.controller;

import kpi.supplychain.pojo.User;
import kpi.supplychain.service.Constants;
import kpi.supplychain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static kpi.supplychain.controller.Views.CONFIG;
import static kpi.supplychain.controller.Views.HOME;
import static kpi.supplychain.controller.Views.LOGIN;

/**
 * Controllers for redirecting.
 */
@Controller
public class ViewsController {

    /**
     * {@inheritDoc}.
     */
    @Autowired
    private UserService userService;

    /**
     * Shows home page.
     * @return view name
     */
    @RequestMapping({"/home"})
    public final String showHomePage(Model model,
                                     HttpServletRequest request) {
        User loggedUser = userService.
                findByLogin(request.getUserPrincipal().getName());
        model.addAttribute(Constants.CURRENT_USER, loggedUser);
        if (loggedUser.getRole().getName().equals(Constants.ROLE_ADMIN)) {
            model.addAttribute(userService.getUsers());
        }
        return HOME;
    }

    /**
     * Shows login page.
     * @return view name
     */
    @RequestMapping({"/login"})
    public final String showLoginPage() {
        return LOGIN;
    }

    @RequestMapping({"/configuration"})
    public final String showConfigPage() {
        return CONFIG;
    }
}
