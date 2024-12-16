package com.bitspark;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemInfo {

    public static void main(String[] args) {
        // 获取操作系统信息
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String osArch = System.getProperty("os.arch");
        
        // 获取Java虚拟机信息
        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");

        // 获取主机名和IP地址
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostName = inetAddress.getHostName();
            String hostAddress = inetAddress.getHostAddress();
            System.out.println("主机名: " + hostName);
            System.out.println("IP地址: " + hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 获取CPU信息
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        if (osBean instanceof OperatingSystemMXBean) {
            //double systemCpuLoad = ((OperatingSystemMXBean) osBean).getSystemCpuLoad() * 100;
            int availableProcessors = osBean.getAvailableProcessors();
            System.out.println("操作系统: " + osName);
            System.out.println("操作系统版本: " + osVersion);
            System.out.println("操作系统架构: " + osArch);
            System.out.println("Java版本: " + javaVersion);
            System.out.println("Java供应商: " + javaVendor);
            System.out.println("可用处理器数: " + availableProcessors);
           // System.out.println("系统CPU负载: " + systemCpuLoad + "%");
        }

        // 获取内存信息
        long totalMemory = Runtime.getRuntime().totalMemory() / (1024 * 1024); // 单位MB
        long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024); // 单位MB
        long maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024); // 单位MB
        System.out.println("JVM最大内存: " + maxMemory + " MB");
        System.out.println("JVM已分配内存: " + totalMemory + " MB");
        System.out.println("JVM空闲内存: " + freeMemory + " MB");

        // 获取硬盘信息 (依赖第三方库)
        // Java 标准库本身没有提供硬盘信息 API，通常使用第三方库（如 Apache Commons IO 或 OSHI）
        // 这里给出一个示例，硬盘信息可以通过外部工具或依赖库来获取
        System.out.println("硬盘信息: 需要第三方库支持，无法直接通过 Java 获取。");
    }
}
