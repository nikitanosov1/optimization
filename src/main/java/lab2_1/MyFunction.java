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

    public double[] calcGradientVector(double[] vector) {
        double x = vector[0];
        double y = vector[1];
        double z = vector[2];
        return calcGradientVector(x, y, z);
    }

    public double[] calcAntiGradientVector(double x, double y, double z) {
        double[] gradientVector = calcGradientVector(x, y, z);
        gradientVector[0] = -gradientVector[0];
        gradientVector[1] = -gradientVector[1];
        gradientVector[2] = -gradientVector[2];
        return gradientVector;
    }

    public double[][] calcMatrixOfDoubleDerivatives(double x, double y, double z) {
        double f_xx = 4 * Math.pow(Math.cos(alpha), 2) + 6 * Math.pow(Math.sin(alpha), 2);
        double f_yy = 4 * Math.pow(Math.sin(alpha), 2) + 6 * Math.pow(Math.cos(alpha), 2);
        double f_xy = -2 * Math.sin(2 * alpha);
        double f_zz = 12 * Math.pow(z, 2);

        double[][] matrix = new double[][] {
                new double[]{f_xx, f_xy,    0},
                new double[]{f_xy, f_yy,    0},
                new double[]{   0,    0, f_zz},
        };
        return matrix;
    }

    public double[][] calcMatrixOfDoubleDerivatives(double[] vector) {
        double x = vector[0];
        double y = vector[1];
        double z = vector[2];
        return calcMatrixOfDoubleDerivatives(x, y, z);
    }
}
