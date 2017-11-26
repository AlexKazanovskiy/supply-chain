package kpi.supplychain.model.configuration;

import java.util.Arrays;

public class LocalWarehouse extends Warehouse {
    private double[] expectedValues;
    private double[] standartDeviations;
    private int region;

    @Override
    public String toString() {
        return "LocalWarehouse [id=" + getId() + ", adress=" + getAdress() + ", expectedValues="
                + Arrays.toString(getExpectedValues()) + ", standartDeviations=" + Arrays.toString(getStandartDeviations()) + "]";
    }

    public double[] getExpectedValues() {
        return expectedValues;
    }

    public void setExpectedValues(double[] expectedValues) {
        this.expectedValues = expectedValues;
    }

    public double[] getStandartDeviations() {
        return standartDeviations;
    }

    public void setStandartDeviations(double[] standartDeviations) {
        this.standartDeviations = standartDeviations;
    }

    public double getAllDemands() {
        double sum = 0;
        for (int i = 0; i < getExpectedValues().length; i++) {
            sum += getExpectedValues()[i];
        }
        return sum;

    }

    public double getAllTeaDemands() {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += getExpectedValues()[i];
        }
        return sum;
    }

    public double getAllSupDemands() {
        double sum = 0;
        for (int i = 3; i < 5; i++) {
            sum += getExpectedValues()[i];
        }
        return sum;
    }

    public double getAllSouseDemands() {
        double sum = 0;
        for (int i = 5; i < 7; i++) {
            sum += getExpectedValues()[i];
        }
        return sum;
    }


    public double getAllTeaDeviation() {
        double sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += getStandartDeviations()[i] * getStandartDeviations()[i];
        }
        return Math.sqrt(sum);
    }

    public double getAllSupDeviation() {
        double sum = 0;
        for (int i = 3; i < 5; i++) {
            sum += getStandartDeviations()[i] * getStandartDeviations()[i];
        }
        return Math.sqrt(sum);
    }

    public double getAllSouseDeviation() {
        double sum = 0;
        for (int i = 5; i < 7; i++) {
            sum += getStandartDeviations()[i] * getStandartDeviations()[i];
        }
        return Math.sqrt(sum);
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }
}
