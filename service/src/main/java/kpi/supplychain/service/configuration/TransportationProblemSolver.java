package kpi.supplychain.service.configuration;

import java.io.IOException;
import java.sql.Date;
import java.util.Set;

import kpi.supplychain.model.configuration.LocalWarehouse;
import kpi.supplychain.model.configuration.Network;
import kpi.supplychain.model.configuration.Route;
import lpsolve.LpSolve;
import lpsolve.LpSolveException;
import org.springframework.stereotype.Service;

@Service(value = "TransportationProblemSolver")
public class TransportationProblemSolver {

    protected Boolean mDebug = false;

    protected int mCountOfProduction = 2;
    protected int mCountOfNational = 2;
    protected int mCountOfRegional = 2;

    protected int mCountOfProducts = 2;
    protected int mCountOfTtansports = 2;

    protected int mCountOfRelationship;

    int regCount;
    int week;

    protected double[] distances = new double[]{851, 1322, 819, 1286, 476, 0, 0, 478, 553, 476, 479, 811, 143, 432, 731, 434, 476, 716, 793, 0, 133, 466,
            502, 795, 732, 467};
    protected double[] prices = new double[]{0.36, 0.687};
    protected double[] volumes = new double[]{33, 15};
    protected double[][] b;
    protected double[][] a;

    public double[] getDistances() {
        return distances;
    }

    public void setDistances(double[] distances) {
        this.distances = distances;
        mCountOfRelationship = distances.length;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
        mCountOfTtansports = prices.length;
    }

    public double[] getVolumes() {
        return volumes;
    }

    public void setVolumes(double[] volumes) {
        this.volumes = volumes;
    }

    public double[][] getB() {
        return b;
    }

    public void setB(double[][] b) {
        this.b = b;
        mCountOfProducts = b.length;
        mCountOfRegional = b[0].length;
    }

    public void setB(Network netwotk) {
        mCountOfProducts = 3;
        mCountOfRegional = 10;
        b = new double[3][10];
        for (LocalWarehouse local : netwotk.getLocal()) {
            Set<Integer> keys = local.getRoutes().keySet();
            for (Integer key : keys) {
                b[0][key] += local.getAllTeaDemands() * week;
                b[1][key] += local.getAllSupDemands() * week;
                b[2][key] += local.getAllSouseDemands() * week;
            }
        }
    }

    public double[][] getA() {
        return a;
    }

    public void setA(Network netwotk) {
        mCountOfProduction = netwotk.getProducerCount();
        this.a = new double[netwotk.getProducerCount()][3];
        for (LocalWarehouse local : netwotk.getLocal()) {
            a[0][0] += local.getAllTeaDemands() * week;
            a[1][1] += local.getAllSupDemands() * week;
            a[2][2] += local.getAllSouseDemands() * week;
        }
    }

    public void setA(double[][] a, Network network) {
        mCountOfProduction = network.getProducerCount();
        this.a = a;
    }

    public TransportationProblemSolver() {
    }

    public TransportationProblemSolver(Boolean debug) {
        this.mDebug = debug;
    }

    public void setUp(Boolean debug, int regCount, int week) {
        this.mDebug = debug;
        this.regCount = regCount;
        this.week = week;
    }

    public void solveTransportationProblem(double result, int[] y, double[][] c, int week, Network network) throws LpSolveException, IOException {
        mCountOfNational = mCountOfRelationship / (mCountOfProduction + mCountOfRegional);

        System.out.println("Size of problem:");
        System.out.println("Production " + mCountOfProduction);
        System.out.println("National " + mCountOfNational);
        System.out.println("Regional " + mCountOfRegional);
        System.out.println("Products " + mCountOfProducts);
        System.out.println("Transport kind " + mCountOfTtansports);

        double[] sum = new double[3];
        double[] s = new double[3];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("b" + i + "" + j + " " + b[i][j]);
                sum[i] += b[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("a" + i + "" + j + " " + a[i][j]);
                s[i] += a[i][j];
            }
        }

        System.out.println(sum[0]);
        System.out.println(sum[1]);
        System.out.println(sum[2]);
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);

        // create solver
        LpSolve solver = LpSolve.makeLp(0, mCountOfRelationship * mCountOfTtansports + mCountOfRelationship * mCountOfProducts);
        for (int i = 0; i < mCountOfRelationship * mCountOfTtansports; i++) {
            solver.setInt(i + 1, true);
            // System.out.println("Set integer to " + i);
        }

        solver.strSetObjFn(createObjectiveFunction(network));

        // create constraints of b
        for (int i = 0; i < mCountOfRegional; i++) {
            for (int j = 0; j < mCountOfProducts; j++) {
                solver.strAddConstraint(createBConstraint(i, j), LpSolve.GE, b[j][i]);
            }
        }

        // create constraints of a
        for (int i = 0; i < mCountOfProduction; i++) {
            for (int j = 0; j < mCountOfProducts; j++) {
                solver.strAddConstraint(createAConstraint(i, j), LpSolve.LE, a[j][i]);
            }

        }

        // create constraints of equals nationals pr
        for (int i = 0; i < mCountOfNational; i++) {
            for (int j = 0; j < mCountOfProducts; j++) {
                solver.strAddConstraint(createNationalEqualsConstraint(i, j), LpSolve.EQ, 0);
            }
        }

        // create constraints of transportation products
        for (int i = 0; i < mCountOfRelationship; i++) {
            solver.strAddConstraint(createTransportProductConstraint(i), LpSolve.LE, 0);
        }

        long startUnixTime = System.currentTimeMillis();
        System.out.println(new Date(startUnixTime).toGMTString());
        solver.solve();
        long endUnixTime = System.currentTimeMillis();
        System.out.println(new Date(endUnixTime).toGMTString());
        System.out.println("Duration of solve: " + (endUnixTime - startUnixTime) + " millis");

        // print solution
        System.out.println("Value of objective function: " + solver.getObjective());
        network.setRegionTransportCost(solver.getObjective() * 4 / this.week);

        double[] var = solver.getPtrVariables();
        double[][] volumes = new double[mCountOfNational][3];
        double[][] volumes2 = new double[mCountOfRegional][3];
        double[][] volumes3 = new double[mCountOfRegional][3];

        double[][] z = new double[26][2];
        double[][] x = new double[26][3];

        for (int i = 0; i < var.length; i++) {
            if (i < mCountOfRelationship * mCountOfTtansports) {
                if (var[i] > 0) {
                    int index = i / mCountOfTtansports;
                    int tr = i % mCountOfTtansports;
                    //System.out.println("Z" + index + " by transType " + tr + " : " + var[i]);
                    z[index][tr] = var[i];
                }
            } else {
                int j = i - mCountOfRelationship * mCountOfTtansports;
                if (var[i] > 0) {
                    int index = j / mCountOfProducts;
                    int tr = j % mCountOfProducts;
                    //System.out.println("X" + index + " product" + tr + " :" + var[i]);
                    x[index][tr] = var[i];

                }
            }
        }

        for (int i = 0; i < 6; i++) {
            int from = i / 2;
            int to = i % 2;
            if (z[i][0] + z[i][1] == 0) {
                network.getNational()[to].getRoutes().remove(from);

            } else {
                Route route = network.getNational()[to].getRoutes().get(from);
                route.setTruck(new int[2]);
                route.getTruck()[0] = (int) z[i][0];
                route.getTruck()[1] = (int) z[i][1];
                route.setVolumes(new double[3]);
                route.getVolumes()[0] = x[i][0];
                route.getVolumes()[1] = x[i][1];
                route.getVolumes()[2] = x[i][2];
                System.out.println("Route from" + from + " to" + to + " " + z[i][0] + " " + z[i][1]);
            }
        }

        for (int i = 6; i < 26; i++) {
            int from = (i - 6) / 10;
            int to = (i - 6) % 10;
            if (z[i][0] + z[i][1] == 0) {
                network.getRegional()[to].getRoutes().remove(from);
            } else {
                Route route = network.getRegional()[to].getRoutes().get(from);
                if (route == null) {
                    System.out.println("HUSTON WE HAVE PROBLEM!");
                } else {
                    route.setTruck(new int[2]);
                    route.getTruck()[0] = (int) z[i][0];
                    route.getTruck()[1] = (int) z[i][1];
                    route.setVolumes(new double[3]);
                    route.getVolumes()[0] = x[i][0];
                    route.getVolumes()[1] = x[i][1];
                    route.getVolumes()[2] = x[i][2];
                    System.out.println("Route from" + from + " to" + to + " " + z[i][0] + " " + z[i][1]);
                }
            }
        }
        solver.deleteLp();
    }

    public String createObjectiveFunction(Network network) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                Route route = null;
                if (i < 6) {
                    int from = i / mCountOfNational;
                    int to = i % mCountOfNational;
                    route = network.getNational()[to].getRoutes().get(from);
                } else {
                    int from = (i - 6) / mCountOfRegional;
                    int to = (i - 6) % mCountOfRegional;
                    route = network.getRegional()[to].getRoutes().get(from);
                }
                if (route == null) {
                    builder.append("99999999999999");
                    builder.append(" ");
                } else {
                    builder.append(prices[j] * distances[i] * volumes[j]);
                    builder.append(" ");
                }
            }
        }
        for (int i = 0; i < mCountOfRelationship * mCountOfProduction; i++) {
            builder.append("0");
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);

        System.out.println("ObjFunc: " + builder.toString());
        return builder.toString();
    }

    public String createBConstraint(int index, int product) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mCountOfRelationship * mCountOfTtansports; i++) {
            builder.append("0");
            builder.append(" ");
        }
        for (int i = 0; i < mCountOfNational * mCountOfProduction * mCountOfProducts; i++) {
            builder.append("0");
            builder.append(" ");
        }
        for (int i = 0; i < mCountOfNational; i++) {
            for (int j = 0; j < mCountOfRegional; j++) {
                for (int k = 0; k < mCountOfProducts; k++) {
                    if ((j == index) && (k == product)) {
                        builder.append("1");
                        builder.append(" ");
                    } else {
                        builder.append("0");
                        builder.append(" ");
                    }
                }
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println("Constraint b[" + index + "][" + product + "]: " + builder.toString());
        return builder.toString();
    }

    public String createAConstraint(int index, int product) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mCountOfRelationship * mCountOfTtansports; i++) {
            builder.append("0");
            builder.append(" ");
        }
        for (int i = 0; i < mCountOfProduction; i++) {
            for (int j = 0; j < mCountOfNational; j++) {
                for (int k = 0; k < mCountOfProducts; k++) {
                    if ((i == index) && (k == product)) {
                        builder.append("1");
                        builder.append(" ");
                    } else {
                        builder.append("0");
                        builder.append(" ");
                    }
                }
            }
        }
        for (int i = 0; i < mCountOfNational * mCountOfRegional * mCountOfProducts; i++) {
            builder.append("0");
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println("Constraint a[" + index + "][" + product + "]: " + builder.toString());
        return builder.toString();
    }

    public String createNationalEqualsConstraint(int index, int product) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mCountOfRelationship * mCountOfTtansports; i++) {
            builder.append("0");
            builder.append(" ");
        }
        for (int i = 0; i < mCountOfProduction; i++) {
            for (int j = 0; j < mCountOfNational; j++) {
                for (int k = 0; k < mCountOfProducts; k++) {
                    if ((j == index) && (k == product)) {
                        builder.append("1");
                        builder.append(" ");
                    } else {
                        builder.append("0");
                        builder.append(" ");
                    }
                }
            }
        }
        for (int i = 0; i < mCountOfNational; i++) {
            for (int j = 0; j < mCountOfRegional; j++) {
                for (int k = 0; k < mCountOfProducts; k++) {
                    if ((i == index) && (k == product)) {
                        builder.append("-1");
                        builder.append(" ");
                    } else {
                        builder.append("0");
                        builder.append(" ");
                    }
                }
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println("Constraint equals[" + index + "][" + product + "]: " + builder.toString());
        return builder.toString();
    }

    public String createTransportProductConstraint(int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mCountOfRelationship; i++) {
            for (int j = 0; j < mCountOfTtansports; j++) {
                if (i == index) {
                    builder.append(-1 * volumes[j]);
                    builder.append(" ");
                } else {
                    builder.append("0");
                    builder.append(" ");
                }
            }
        }
        for (int i = 0; i < mCountOfRelationship; i++) {
            for (int j = 0; j < mCountOfProducts; j++) {
                if (i == index) {
                    builder.append("1");
                    builder.append(" ");
                } else {
                    builder.append("0");
                    builder.append(" ");
                }
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        if (mDebug)
            System.out.println("Constraint tp[" + index + "]: " + builder.toString());
        return builder.toString();
    }
}