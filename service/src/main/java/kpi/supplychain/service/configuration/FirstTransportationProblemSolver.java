package kpi.supplychain.service.configuration;

import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.model.configuration.Route;
import lpsolve.LpSolve;
import lpsolve.LpSolveException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;

@Service(value = "FirstTransportationProblemSolver")
public class FirstTransportationProblemSolver {
    int n = 7;
    int weeks = 2;

    public void setN(int n) {
        this.n = n;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public FirstTransportationProblemSolver() {
    }

    public FirstTransportationProblemSolver(int n, int week) {
        this.n = n;
        this.weeks = week;
    }

    Boolean mDebug = false;

    public void solveProblem(Network network) throws LpSolveException {
        LpSolve solver = LpSolve.makeLp(0, network.getLocalCount() * network.getRegionalCount() + network.getRegionalCount());
        for (int i = 0; i < network.getLocalCount() * network.getRegionalCount() + network.getRegionalCount(); i++) {
            solver.setBinary(i + 1, true);
            // System.out.println("Set binary to " + i);
        }

        solver.strSetObjFn(createObjectiveFunction(network));

        for (int i = 0; i < network.getLocalCount(); i++) {
            solver.strAddConstraint(createBConstraint(i, network), LpSolve.GE, 1);
        }


        for (int i = 0; i < network.getRegionalCount(); i++) {
            solver.strAddConstraint(createYConstraint(i, network), LpSolve.LE, 0);
        }

        solver.strAddConstraint(createNConstraint(network), LpSolve.EQ, n);

        long startUnixTime = System.currentTimeMillis();
        System.out.println(new Date(startUnixTime).toGMTString());
        solver.solve();
        long endUnixTime = System.currentTimeMillis();
        System.out.println(new Date(endUnixTime).toGMTString());
        System.out.println("Duration of solve: " + (endUnixTime - startUnixTime) + " millis");

        double result = solver.getObjective();
        System.out.println("Value of objective function: " + solver.getObjective());

        network.setLocalTransportCost(solver.getObjective());

        double[] var = solver.getPtrVariables();

        //solver.deleteLp();

        int[][] x = new int[network.getRegionalCount()][network.getLocalCount()];
        for (int i = 0; i < network.getRegionalCount(); i++) {
            for (int j = 0; j < network.getLocalCount(); j++) {
                x[i][j] = (int) var[i * network.getLocalCount() + j];
                //System.out.println(i+" "+j+" "+x[i][j]);
                if (x[i][j] == 0) {
                    network.getLocal()[j].getRoutes().remove(i);
                }
            }
        }


//
        int[] y = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("Y" + i + " : " + var[network.getRegionalCount() * network.getLocalCount() + i]);
            y[i] = (int) var[network.getRegionalCount() * network.getLocalCount() + i];
        }
        network.setY(y);
    }

    private String createObjectiveFunction(Network network) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < network.getLocalCount(); i++) {
            // ArrayList<Integer> routes = distance.get(i);
            for (int j = 0; j < network.getRegionalCount(); j++) {
                Route route = network.getLocal()[i].getRoutes().get(j);
                if (route != null) {
                    builder.append(network.getLocal()[i].getAllDemands() * route.getKm() / 1000 * 0.67);
                    builder.append(" ");
                } else {
                    builder.append("999999999");
                    builder.append(" ");
                }
            }
        }

        for (int i = 0; i < network.getRegionalCount(); i++) {
            builder.append("0");
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println("ObjFunc: " + builder.toString());
        return builder.toString();
    }

    private String createBConstraint(int in, Network network) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < network.getRegionalCount(); i++) {
            for (int j = 0; j < network.getLocalCount(); j++) {
                if (j == in) {
                    builder.append("1");
                    builder.append(" ");
                } else {
                    builder.append("0");
                    builder.append(" ");
                }

            }
        }

        for (int i = 0; i < network.getRegionalCount(); i++) {
            builder.append("0");
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println(in + " ConstrB: ");// + builder.toString());
        return builder.toString();
    }

    private String createYConstraint(int in, Network network) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < network.getRegionalCount(); i++) {
            for (int j = 0; j < network.getLocalCount(); j++) {
                if (i == in) {
                    builder.append("1");
                    builder.append(" ");
                } else {
                    builder.append("0");
                    builder.append(" ");
                }

            }
        }

        for (int i = 0; i < network.getRegionalCount(); i++) {
            if (i == in) {
                builder.append(network.getLocalCount() * (-1));
                builder.append(" ");
            } else {
                builder.append("0");
                builder.append(" ");
            }

        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println("ConstrY: " + builder.toString());
        return builder.toString();
    }

    private String createNConstraint(Network network) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < network.getRegionalCount(); i++) {
            for (int j = 0; j < network.getLocalCount(); j++) {
                builder.append("0");
                builder.append(" ");

            }
        }

        for (int i = 0; i < network.getRegionalCount(); i++) {
            builder.append("1");
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println("ConstrN: " + builder.toString());
        return builder.toString();
    }
}
