package lab2_1;

import lab1.Functions;
import lab1.GoldenSectionDto;

import java.util.function.Function;

public class Methods {
    public static double[] findMinimumInTheDirectionOfTheVector(MyFunction function, double[] startPoint, double[] direction, double eps) {
        double lenOfDirection = calcNormOfVector(direction);
        double[] step = new double[]{
                direction[0] / lenOfDirection,
                direction[1] / lenOfDirection,
                direction[2] / lenOfDirection,
        };
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

        double[] vectorFromAtoB = new double[] {
                nextPoint[0] - startPoint[0],
                nextPoint[1] - startPoint[1],
                nextPoint[2] - startPoint[2]
        };
        double lengthVectorFromAToB = calcNormOfVector(vectorFromAtoB);

        double[] finalNextPoint = nextPoint;
        Function<Double, Double> hintFunction = (len) -> {
            double x = (finalNextPoint[0] - startPoint[0]) / (lengthVectorFromAToB / len) + startPoint[0];
            double y = (finalNextPoint[1] - startPoint[1]) / (lengthVectorFromAToB / len) + startPoint[1];
            double z = (finalNextPoint[2] - startPoint[2]) / (lengthVectorFromAToB / len) + startPoint[2];

            return function.apply(x, y, z);
        };

        GoldenSectionDto goldenSection = Functions.goldenSection(0, lengthVectorFromAToB, eps, hintFunction);
        double lenWhichGiveUsMinValueOfFunction = goldenSection.getMinX();

        double x = (finalNextPoint[0] - startPoint[0]) / (lengthVectorFromAToB / lenWhichGiveUsMinValueOfFunction) + startPoint[0];
        double y = (finalNextPoint[1] - startPoint[1]) / (lengthVectorFromAToB / lenWhichGiveUsMinValueOfFunction) + startPoint[1];
        double z = (finalNextPoint[2] - startPoint[2]) / (lengthVectorFromAToB / lenWhichGiveUsMinValueOfFunction) + startPoint[2];

        return new double[] {
                x, y, z
        };
    }

    public static double calcNormOfVector(double[] vector) {
        return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2) + Math.pow(vector[2], 2));
    }
}
