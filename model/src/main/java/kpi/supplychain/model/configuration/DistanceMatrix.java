package kpi.supplychain.model.configuration;

import java.util.Arrays;

public class DistanceMatrix {

    private int[][] matrix = new int[201][10];

    public int getDistance(int destination, int origin) {
        return getMatrix()[destination][origin];
    }

    @Override
    public String toString() {
        return "DistanceMatrix [matrix=" + Arrays.toString(getMatrix()) + "]";
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
