import java.util.Random;

public class MatrixUtils {
    public static double[][] createRandomMatrix(int rows, int cols, int numbersLimit) {
        double[][] arr = new double[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = random.nextInt(numbersLimit);
            }
        }
        return arr;
    }

    public static double[][] multiplyMatrix(double[][] m1, double[][] m2) {
        double[][] mResult = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}
