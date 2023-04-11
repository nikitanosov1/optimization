package util;

public class Util {
    /**
     * 3x3
     * @param matrix 3x3
     * @return inverse matrix 3x3
     */
    public static double[][] calculateTheInverseMatrix(double[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new RuntimeException();
        }

        double determinant = calculateDeterminantOfTheMatrix(matrix);
        if (determinant == 0) {
            throw new RuntimeException();
        }

        double[][] inverseMatrix = new double[][] {
                new double[3],
                new double[3],
                new double[3],
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverseMatrix[i][j] = (matrix[(j + 1) % 3][(i + 1) % 3] * matrix[(j + 2) % 3][(i + 2) % 3] -
                        matrix[(j + 1) % 3][(i + 2) % 3] * matrix[(j + 2) % 3][(i + 1) % 3]) / determinant;
            }
        }
        return inverseMatrix;
    }

    /**
     * 3x3
     * @param matrix
     * @return determinant
     */
    public static double calculateDeterminantOfTheMatrix(double[][] matrix) {
        if (matrix.length != 3 || matrix[0].length != 3) {
            throw new RuntimeException();
        }

        double determinant = 0;
        for (int i = 0; i < 3; i++) {
            determinant += matrix[0][i] * matrix[1][(i + 1) % 3] * matrix[2][(i + 2) % 3];
            determinant -= matrix[0][i] * matrix[1][(i + 2) % 3] * matrix[2][(i + 1) % 3];
        }
        return determinant;
    }

    /**
     * calculate norm of vector 3x1
     * @param vector
     * @return
     */
    public static double calcNormOfVector(double[] vector) {
        return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2) + Math.pow(vector[2], 2));
    }
}
