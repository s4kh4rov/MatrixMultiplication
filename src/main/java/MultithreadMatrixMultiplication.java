import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadMatrixMultiplication {
    /**
     * Number of threads
     */
    private int threadsCount;
    /**
     * First matrix to multiply
     */
    private double[][] firstMatrix;
    /**
     * Second matrix to multiply
     */
    private double[][] secondMatrix;
    /**
     * Resulting matrix
     */
    private volatile double[][] resultMatrix;

    public MultithreadMatrixMultiplication(double[][] firstMatrix, double[][] secondMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.threadsCount = Runtime.getRuntime().availableProcessors();
        this.resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];
    }

    /**
     * Performs multiplication of two matrices in multi-threaded mode
     *
     * @return resulting matrix
     */
    public double[][] matrixMultiplication() {
        ExecutorService service = Executors.newFixedThreadPool(threadsCount);
        for (int i = 0; i < firstMatrix.length; i++) {
            service.execute(new MultiplicationThread(i));
        }
        service.shutdown();
        return resultMatrix;
    }

    private class MultiplicationThread implements Runnable {
        /**
         * Line number whose value will be calculated during the execution of the run method
         */
        private int stringIndex;

        public MultiplicationThread(int stringIndex) {
            this.stringIndex = stringIndex;
        }

        /**
         * Calculates the values of the row with the stringIndex
         */
        @Override
        public void run() {
            for (int i = 0; i < firstMatrix.length; i++) {
                for (int j = 0; j < secondMatrix.length; j++) {
                    resultMatrix[stringIndex][i] += firstMatrix[stringIndex][j] * secondMatrix[j][i];
                }
            }
        }
    }
}
