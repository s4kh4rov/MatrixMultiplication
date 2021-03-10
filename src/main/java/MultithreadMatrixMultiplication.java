public class MultithreadMatrixMultiplication {
    private int threadsCount;
    private int[][] firstMatrix;
    private int[][] secondMatrix;
    private volatile int [][] resultMatrix;

    public MultithreadMatrixMultiplication(int[][] firstMatrix, int[][] secondMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.threadsCount = Runtime.getRuntime().availableProcessors();
        this.resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];
    }
}
