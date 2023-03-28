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

    public double[] calcGradientVector(double x, double y, double z) {
        double[] gradientVector = new double[3];
        gradientVector[0] = 4 * ((x - x0) * Math.cos(alpha) + (y - y0) * Math.sin(alpha)) * Math.cos(alpha)
                - 6 * ((y - y0) * Math.cos(alpha) - (x - x0) * Math.sin(alpha)) * Math.sin(alpha);
        gradientVector[1] = 4 * ((x - x0) * Math.cos(alpha) + (y - y0) * Math.sin(alpha)) * Math.sin(alpha)
                + 6 * ((y - y0) * Math.cos(alpha) - (x - x0) * Math.sin(alpha)) * Math.cos(alpha);
        gradientVector[2] = 4 * Math.pow(z, 3);
        return gradientVector;
    }

    public double[] calcAntiGradientVector(double x, double y, double z) {
        double[] gradientVector = calcGradientVector(x, y, z);
        gradientVector[0] = -gradientVector[0];
        gradientVector[1] = -gradientVector[1];
        gradientVector[2] = -gradientVector[2];
        return gradientVector;
    }
}
