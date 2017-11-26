package kpi.supplychain.controller.configuration;

import kpi.supplychain.controller.JsonExceptionInformation;
import kpi.supplychain.model.configuration.ConfigParams;
import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.service.configuration.FirstTransportationProblemSolver;
import lpsolve.LpSolveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by I on 16.06.2015.
 */
@Controller
@RequestMapping("firstTransportationProblem")
public class FirstTransportationProblem {
    @Autowired
    private FirstTransportationProblemSolver firstTransportationProblemSolver;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Network solve(@RequestBody ConfigParams configParams,
                         BindingResult result) throws BindException {
        firstTransportationProblemSolver.setN(configParams.getRegionalWarehouseCount());
        firstTransportationProblemSolver.setWeeks(configParams.getShipmentCycleLength());
        try {
            firstTransportationProblemSolver.solveProblem(configParams.getNetwork());
        } catch (LpSolveException e) {
            result.reject(e.getMessage());
            throw new BindException(result);
        }
        return configParams.getNetwork();
    }

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
