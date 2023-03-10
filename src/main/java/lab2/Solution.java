package lab2;

import lab1.Functions;

import java.util.function.Function;

public class Solution {
    public static void solve() {
        double alpha = Math.PI / 6;
        double x0 = 5;
        double y0 = 2;
        Function<Double, Double> firstFunction = (x) -> 2 * x * x;
        Function<Double, Double> secondFunction = (x) -> 3 * x * x;
        Function<Double, Double> thirdFunction = (x) -> x * x * x * x;
        double xOld = 3;
        double yOld = 1;
        double z = 4;

        double x = xOld * Math.cos(alpha) + yOld * Math.sin(alpha) + x0;
        double y = -xOld * Math.sin(alpha) + yOld * Math.cos(alpha) + y0;
        double eps = Math.pow(10, -3);

        // x
        int step = 1;
        Double aForX = null;
        Double bForX = null;
        double w = firstFunction.apply(x);
        if (firstFunction.apply(x + 1) < w) {
            // min right
            double prevValue = w;
            double curValue = firstFunction.apply(x + step);
            while (curValue < prevValue) {
                step *= 2;
                prevValue = curValue;
                curValue = firstFunction.apply(x + step);
            }
            aForX = x;
            bForX = x + step;
        } else {
            // min left
            double prevValue = w;
            double curValue = firstFunction.apply(x - step);
            while (curValue < prevValue) {
                step *= 2;
                prevValue = curValue;
                curValue = firstFunction.apply(x - step);
            }
            aForX = x - step;
            bForX = x;
        }

        double minX = Functions.goldenSection(aForX, bForX, eps, firstFunction).getMinX();

        // y
        step = 1;
        Double aForY = null;
        Double bForY = null;
        w = secondFunction.apply(y);
        if (secondFunction.apply(y + 1) < w) {
            // min right
            double prevValue = w;
            double curValue = secondFunction.apply(y + step);
            while (curValue < prevValue) {
                step *= 2;
                prevValue = curValue;
                curValue = secondFunction.apply(y + step);
            }
            aForY = y;
            bForY = y + step;
        } else {
            // min left
            double prevValue = w;
            double curValue = secondFunction.apply(y - step);
            while (curValue < prevValue) {
                step *= 2;
                prevValue = curValue;
                curValue = secondFunction.apply(y - step);
            }
            aForY = y - step;
            bForY = y;
        }
        double minY = Functions.goldenSection(aForX, bForX, eps, secondFunction).getMinX();

        // z
        step = 1;
        Double aForZ = null;
        Double bForZ = null;
        w = thirdFunction.apply(z);
        if (thirdFunction.apply(z + 1) < w) {
            // min right
            double prevValue = w;
            double curValue = thirdFunction.apply(z + step);
            while (curValue < prevValue) {
                step *= 2;
                prevValue = curValue;
                curValue = thirdFunction.apply(z + step);
            }
            aForZ = z;
            bForZ = z + step;
        } else {
            // min left
            double prevValue = w;
            double curValue = thirdFunction.apply(z - step);
            while (curValue < prevValue) {
                step *= 2;
                prevValue = curValue;
                curValue = thirdFunction.apply(z - step);
            }
            aForZ = z - step;
            bForZ = z;
        }
        double minZ = Functions.goldenSection(aForZ, bForZ, eps, thirdFunction).getMinX();
        System.out.println();
        System.out.println("minX' = " + minX);
        System.out.println("minY' = " + minY);
        System.out.println("minZ = " + minZ);

        double newXOld = (minX - Math.sin(alpha) * minY / Math.cos(alpha) + y0 * Math.sin(alpha) / Math.cos(alpha) - x0) / (Math.sin(alpha) * Math.sin(alpha) / Math.cos(alpha) + Math.cos(alpha));

        System.out.println("newXOld' = " + newXOld);
    }
}
