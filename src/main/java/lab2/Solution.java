package lab2;

import java.util.Arrays;

public class Solution {
    public static void solve() {
        MyFunction function = new MyFunction();
        double[] startPoint = new double[]{4, 1, -1};
        double eps = Math.pow(10, -3);

        double[] result = Methods.findMinimumInTheDirectionOfTheVector(function, startPoint, new double[]{1, 1, 1});

        System.out.println(Arrays.toString(result));
    }
}
