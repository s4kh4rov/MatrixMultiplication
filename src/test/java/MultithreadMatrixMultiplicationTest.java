import org.junit.Test;

import static org.junit.Assert.*;

public class MultithreadMatrixMultiplicationTest {

    @Test
    public void matrixMultiplication() {
        double[][] firstMatrix = {{1, 3}, {4, 7}, {5, 8}};
        double[][] secondMatrix = {{2, 5, 8}, {3, 9, 4}};
        double[][] result = {{11, 32, 20}, {29, 83, 60}, {34, 97, 72}};
        MultithreadMatrixMultiplication matrixMultiplication = new MultithreadMatrixMultiplication(firstMatrix, secondMatrix);
        assertArrayEquals(result, matrixMultiplication.matrixMultiplication());
    }

    @Test
    public void computationSpeedComparison() {
        double[][] firstMatrix = MatrixUtils.createRandomMatrix(500, 500, 1000);
        double[][] secondMatrix = MatrixUtils.createRandomMatrix(500, 500, 1000);
        MultithreadMatrixMultiplication matrixMultiplication = new MultithreadMatrixMultiplication(firstMatrix, secondMatrix);
        long start1 = System.currentTimeMillis();
        MatrixUtils.multiplyMatrix(firstMatrix, secondMatrix);
        long end1 = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        matrixMultiplication.matrixMultiplication();
        long end2 = System.currentTimeMillis();
        assertTrue((end1 - start1) > (end2 - start2));
    }
}