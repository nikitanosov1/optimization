package lab2_1;

public class Solution {
    public static void solve() {
        MyFunction function = new MyFunction();
        double[] startPoint = new double[]{10, 50, 10};
        double eps = Math.pow(10, -6);
        double[] result = Methods.findMinimumInTheDirectionOfTheVector(function, startPoint, new double[]{0, 0, -1}, eps);

//        double z = -0.01;
//        while (z < 0.01) {
//            System.out.println(function.apply(50,100,z));
//            z += 0.0001;
//        }
        System.out.println("x = " + result[0]);
        System.out.println("y = " + result[1]);
        System.out.println("z = " + result[2]);
    }
}