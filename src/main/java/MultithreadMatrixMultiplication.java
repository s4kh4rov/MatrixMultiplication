import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadMatrixMultiplication {
    private int threadsCount;
    private double[][] firstMatrix;
    private double[][] secondMatrix;
    private volatile double[][] resultMatrix;

    public MultithreadMatrixMultiplication(double[][] firstMatrix, double[][] secondMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.threadsCount = Runtime.getRuntime().availableProcessors();
        this.resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];
    }

    public double[][] matrixMultiplication() {
        ExecutorService service = Executors.newFixedThreadPool(threadsCount);
        for (int i = 0; i < firstMatrix.length; i++) {
            service.execute(new MultiplicationThread(i));
        }
        service.shutdown();
        return resultMatrix;
    }

    private class MultiplicationThread implements Runnable {
        private int stringIndex;

        public MultiplicationThread(int stringIndex) {
            this.stringIndex = stringIndex;
        }

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
