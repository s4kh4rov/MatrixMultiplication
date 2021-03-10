import java.util.Random;

public class MatrixUtils {
    /**
     * Creates a matrix of a given size filled with random values
     *
     * @param rows         the number of rows in the matrix
     * @param cols         the number of columns in the matrix
     * @param numbersLimit the maximum random number that can be the value of the matrix cell
     * @return a new matrix filled with numbers
     */
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

    /**
     * Multiplies matrices in single-threaded mode
     *
     * @param m1 first matrix
     * @param m2 second matrix
     * @return matrix resulting from multiplication
     */
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
