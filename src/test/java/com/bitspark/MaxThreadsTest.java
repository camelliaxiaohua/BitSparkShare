package com.bitspark;

import java.util.concurrent.*;

public class MaxThreadsTest {

    public static void main(String[] args) {
        int maxThreads = Integer.MAX_VALUE;  // 最大线程数
        ExecutorService executor = Executors.newCachedThreadPool();
        long startTime = System.nanoTime();

        try {
            // 循环增加线程，直到系统无法再创建线程
            for (int i = 0; i < maxThreads; i++) {
                executor.submit(() -> {
                    // 让每个线程做一些无意义的任务
                    try {
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        // 线程中断
                    }
                });
            }
        } catch (OutOfMemoryError e) {
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;  // 转换为毫秒
            System.out.println("无法再创建线程，系统最大线程数: " + maxThreads);
            System.out.println("测试耗时: " + duration + " 毫秒");
        }

        // 关闭 executor
        executor.shutdown();
    }
}
