package lab2;

public class MyFunction {
    private double alpha = Math.PI / 6;
    private double x0 = 5;
    private double y0 = 2;

    double apply(double x, double y, double z) {
        return 2 * Math.pow(x * Math.cos(alpha) + y * Math.sin(alpha) + x0, 2)
                + 3 * Math.pow(-x * Math.sin(alpha) + y * Math.cos(alpha) + y0, 2)
                + Math.pow(z, 4);
    }
}
