package lab2_3;

import lab2_1.MyFunction;

import static lab2_1.Methods.calcNormOfVector;
import static lab2_1.Methods.findMinimumInTheDirectionOfTheVector;

public class Methods {
    public static double[] findGlobalMinimumWithGradient(MyFunction function, double[] startPoint, double stepEps) {
        double[] curPoint = startPoint;
        double step = Double.MAX_VALUE;
        while (step > stepEps) {
            double[] gradient = function.calcGradientVector(curPoint[0], curPoint[1], curPoint[2]);
            double[] result = findMinimumInTheDirectionOfTheVector(function, curPoint, gradient, stepEps);
            double[] stepVector = new double[] {
                    result[0] - curPoint[0],
                    result[1] - curPoint[1],
                    result[2] - curPoint[2]
            };

            curPoint = result;
            step = calcNormOfVector(stepVector);
        }
        return curPoint;
    }
}
