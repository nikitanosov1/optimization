package lab2;

import java.util.Arrays;

public class Methods {
    public static double[] findMinimumInTheDirectionOfTheVector(MyFunction function, double[] startPoint, double[] direction) {
        double[] step = new double[]{ direction[0] / direction[1], 1, direction[1] / direction[2]};
        double[] nextPoint = new double[] {
                startPoint[0] + step[0],
                startPoint[1] + step[1],
                startPoint[2] + step[2]
        };
        if (function.apply(startPoint) < function.apply(nextPoint)) {
            step[0] = -step[0];
            step[1] = -step[1];
            step[2] = -step[2];
        }


        double[] curPoint = new double[]{
                startPoint[0],
                startPoint[1],
                startPoint[2]
        };
        nextPoint = new double[] {
                startPoint[0] + step[0],
                startPoint[1] + step[1],
                startPoint[2] + step[2]
        };
        double curValue = function.apply(startPoint);
        double nextValue = function.apply(nextPoint);

        while (nextValue < curValue) {
            System.out.println(Arrays.toString(nextPoint));
            curPoint = nextPoint;
            curValue = nextValue;

            nextPoint = new double[] {
                    nextPoint[0] + step[0],
                    nextPoint[1] + step[1],
                    nextPoint[2] + step[2]
            };
            nextValue = function.apply(nextPoint);

            step[0] *= 2;
            step[1] *= 2;
            step[2] *= 2;
        }


        return nextPoint;
    }
}
