package lab3;

import lab2.MyFunction;

import static lab3.Methods.findGlobalMinimum;

public class Solution {
    public static void main(String[] args) {
        MyFunction function = new MyFunction();
        double[] startPoint = new double[]{10, 50, -70};
        double eps = Math.pow(10, -10);

        double[] minimum = findGlobalMinimum(function, startPoint, eps);
        System.out.println("x = " + minimum[0]);
        System.out.println("y = " + minimum[1]);
        System.out.println("z = " + minimum[2]);
    }
}
