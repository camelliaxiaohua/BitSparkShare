package com.bitspark;

import java.util.Random;

public class ExtremeMatrixMultiplication {

    public static void main(String[] args) {
        int size = 2048    ; // 超大矩阵：8192x8192
        System.out.println("开始极限矩阵乘法，矩阵大小: " + size + "x" + size);

        long startTime = System.nanoTime();
        int[][] matrixA = generateMatrix(size);
        int[][] matrixB = generateMatrix(size);
        int[][] result = new int[size][size];

        multiplyMatrices(matrixA, matrixB, result, size);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // 转换为毫秒
        System.out.println("极限矩阵乘法计算完成，耗时: " + duration + " 毫秒");
    }

    // 生成随机矩阵
    private static int[][] generateMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(100); // 随机数填充
            }
        }
        return matrix;
    }

    // 矩阵乘法
    private static void multiplyMatrices(int[][] A, int[][] B, int[][] result, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }
}
