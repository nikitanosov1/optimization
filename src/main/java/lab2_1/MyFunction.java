package lab2_1;

public class MyFunction {
    private double alpha = Math.PI / 6;
    private double x0 = 5;
    private double y0 = 2;

    double apply(double x, double y, double z) {
        return 2 * Math.pow((x - x0) * Math.cos(alpha) + (y - y0) * Math.sin(alpha), 2)
                + 3 * Math.pow((y - y0) * Math.cos(alpha) - (x - x0) * Math.sin(alpha), 2)
                + Math.pow(z, 4);
    }

    double apply(double[] vector) {
        if (vector.length != 3) {
            throw new RuntimeException();
        }
        double x = vector[0];
        double y = vector[1];
        double z = vector[2];
        return 2 * Math.pow((x - x0) * Math.cos(alpha) + (y - y0) * Math.sin(alpha), 2)
                + 3 * Math.pow((y - y0) * Math.cos(alpha) - (x - x0) * Math.sin(alpha), 2)
                + Math.pow(z, 4);
    }
}
