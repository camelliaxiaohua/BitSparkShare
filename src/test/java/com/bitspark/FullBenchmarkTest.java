package com.bitspark;

import java.util.*;
import java.util.concurrent.*;

public class FullBenchmarkTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. 矩阵乘法基准测试
        int matrixSize = 1024; // 矩阵大小
        System.out.println("开始矩阵乘法，矩阵大小: " + matrixSize + "x" + matrixSize);
        long matrixMultiplicationTime = runMatrixMultiplication(matrixSize);

        // 2. 内存带宽测试
        int memoryArraySize = 1024 * 1024 * 10; // 10MB 数据
        System.out.println("开始内存带宽测试，数据大小: " + memoryArraySize + " 字节");
        long memoryBandwidthTime = runMemoryBandwidthTest(memoryArraySize);

        // 3. 多线程计算基准测试
        int taskCount = 1000; // 设置任务数
        System.out.println("开始执行多线程计算任务，总任务数: " + taskCount);
        long multiThreadedComputationTime = runMultiThreadedComputation(taskCount);

        // 4. 排序基准测试
        int dataSize = 1000000; // 数据量
        System.out.println("开始排序测试，数据大小: " + dataSize);
        long sortingTime = runSortingBenchmark(dataSize);

        // 打印结果
        System.out.println("\n--- 测试结果 ---");
        System.out.println("矩阵乘法耗时: " + matrixMultiplicationTime + " 毫秒");
        System.out.println("内存带宽测试耗时: " + memoryBandwidthTime + " 毫秒");
        System.out.println("多线程计算耗时: " + multiThreadedComputationTime + " 毫秒");
        System.out.println("排序测试耗时: " + sortingTime + " 毫秒");
    }

    // 矩阵乘法基准测试
    private static long runMatrixMultiplication(int size) {
        int[][] matrixA = generateMatrix(size);
        int[][] matrixB = generateMatrix(size);
        int[][] result = new int[size][size];

        long startTime = System.nanoTime();
        multiplyMatrices(matrixA, matrixB, result, size);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000; // 转换为毫秒
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

    // 内存带宽测试
    private static long runMemoryBandwidthTest(int arraySize) {
        long[] data = new long[arraySize];
        long startTime = System.nanoTime();

        // 填充数据
        for (int i = 0; i < arraySize; i++) {
            data[i] = i;
        }

        // 读取数据以测试带宽
        long sum = 0;
        for (int i = 0; i < arraySize; i++) {
            sum += data[i];
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // 转换为毫秒
    }

    // 多线程计算基准测试
    private static long runMultiThreadedComputation(int taskCount) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // 提交多个计算任务
        List<Callable<Long>> tasks = new ArrayList<>();
        for (int i = 0; i < taskCount; i++) {
            tasks.add(() -> {
                return computeHeavyTask();
            });
        }

        long startTime = System.nanoTime();
        // 执行任务并等待结果
        List<Future<Long>> results = executor.invokeAll(tasks);

        // 收集所有结果
        long total = 0;
        for (Future<Long> result : results) {
            total += result.get();
        }

        executor.shutdown();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // 转换为毫秒
    }

    // 模拟计算任务
    private static long computeHeavyTask() {
        long result = 0;
        for (int i = 0; i < 100000; i++) {
            result += Math.sqrt(i); // 执行一些数学计算
        }
        return result;
    }

    // 排序基准测试
    private static long runSortingBenchmark(int dataSize) {
        int[] data = new int[dataSize];
        Random random = new Random();

        // 生成随机数据
        for (int i = 0; i < dataSize; i++) {
            data[i] = random.nextInt(dataSize);
        }

        long startTime = System.nanoTime();

        // 使用快速排序进行排序
        Arrays.sort(data);

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000; // 转换为毫秒
    }
}
