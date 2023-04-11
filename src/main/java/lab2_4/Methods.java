package lab2_4;

import lab2_1.MyFunction;

import static util.Util.calcNormOfVector;
import static util.Util.calculateTheInverseMatrix;

public class Methods {
    public static double[] findGlobalMinimumWithNewton(MyFunction function, double[] startPoint, double stepEps) {
        double[] curPoint = startPoint;
        double step = Double.MAX_VALUE;

        while (step > stepEps) {
            double[][] inverseMatrix = calculateTheInverseMatrix(function.calcMatrixOfDoubleDerivatives(curPoint));
            double[] gradient = function.calcGradientVector(curPoint);

            double[] nextPoint = new double[]{
                    curPoint[0] - (inverseMatrix[0][0] * gradient[0] + inverseMatrix[0][1] * gradient[1] + inverseMatrix[0][2] * gradient[2]),
                    curPoint[1] - (inverseMatrix[1][0] * gradient[0] + inverseMatrix[1][1] * gradient[1] + inverseMatrix[1][2] * gradient[2]),
                    curPoint[2] - (inverseMatrix[2][0] * gradient[0] + inverseMatrix[2][1] * gradient[1] + inverseMatrix[2][2] * gradient[2]),
            };

            double[] stepVector = new double[] {
                    nextPoint[0] - curPoint[0],
                    nextPoint[1] - curPoint[1],
                    nextPoint[2] - curPoint[2]
            };

            curPoint = nextPoint;
            step = calcNormOfVector(stepVector);
        }
        return curPoint;
    }
}