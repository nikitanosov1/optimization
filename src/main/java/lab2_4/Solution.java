package lab2_4;

import lab2_1.MyFunction;

import static lab2_4.Methods.findGlobalMinimumWithNewton;

public class Solution {
    public static void main(String[] args) {
        MyFunction function = new MyFunction();
        double[] startPoint = new double[]{10, 50, -70};
        double eps = Math.pow(10, -10);

        double[] minimum = findGlobalMinimumWithNewton(function, startPoint, eps);
        System.out.println("x = " + minimum[0]);
        System.out.println("y = " + minimum[1]);
        System.out.println("z = " + minimum[2]);

//        double[][] matrix = new double[][] {
//                new double[]{2, 5, 7},
//                new double[]{6, 3, 4},
//                new double[]{5, -2, -3},
//        };
//        double[][] result = calculateTheInverseMatrix(matrix);
//        Arrays.stream(result).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}