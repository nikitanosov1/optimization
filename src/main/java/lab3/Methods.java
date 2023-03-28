package lab3;

import lab2.MyFunction;

import java.util.Arrays;

import static lab2.Methods.calcNormOfVector;
import static lab2.Methods.findMinimumInTheDirectionOfTheVector;

public class Methods {
    public static double[] findGlobalMinimum(MyFunction function, double[] startPoint, double stepEps) {
        double[] curPoint = startPoint;
        double[][] directions = new double[][]{
                new double[] { 1, 0, 0}, // e_x
                new double[] { 0, 1, 0}, // e_y
                new double[] { 0, 0, 1}  // e_z
        };

        double step = Double.MAX_VALUE;
        while (step > stepEps) {
            step = 0;
            for (int i = 0; i < 3; i++) {
                double[] result = findMinimumInTheDirectionOfTheVector(function, curPoint, directions[i], stepEps);

                double[] stepVector = new double[] {
                        result[0] - curPoint[0],
                        result[1] - curPoint[1],
                        result[2] - curPoint[2]
                };

                curPoint = result;
                // System.out.println(Arrays.toString(curPoint));

                step = Math.max(step, calcNormOfVector(stepVector));
            }
        }

        return curPoint;
    }
}