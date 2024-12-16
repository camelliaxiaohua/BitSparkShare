package com.bitspark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CPUBenchmark {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int arraySize = 1000000; // 数组大小
        int numThreads = Runtime.getRuntime().availableProcessors(); // 使用系统的CPU核心数
        System.out.println("使用的线程数: " + numThreads);

        long startTime = System.nanoTime();
        System.out.println("开始计算...");

        // 创建一个 ExecutorService 来管理线程池
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        
        // 用于存储计算结果的任务
        List<Future<Long>> futures = new ArrayList<>();

        // 分割任务，每个线程处理一部分
        for (int i = 0; i < numThreads; i++) {
            int start = i * arraySize / numThreads;
            int end = (i + 1) * arraySize / numThreads;

            Callable<Long> task = () -> {
                return computeTask(start, end, arraySize);
            };

            futures.add(executor.submit(task));
        }

        // 等待所有任务完成并收集结果
        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // 转换为毫秒
        System.out.println("计算完成，耗时: " + duration + " 毫秒");
    }

    // 模拟计算任务，返回计算结果的和
    public static long computeTask(int start, int end, int arraySize) {
        Random random = new Random();
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += random.nextInt(arraySize); // 模拟计算
        }
        return sum;
    }
}
