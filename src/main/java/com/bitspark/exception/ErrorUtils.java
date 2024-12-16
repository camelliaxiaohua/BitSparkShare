package com.bitspark.exception;

/**
 * @Datetime: 2024年12月14日14:27
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.exception
 * @Project: BitSpark-Share-Backend
 * @Description: 异常处理工具类
 */
public class ErrorUtils {

    /**
     * 条件成立则抛出异常
     * @param condition 条件
     * @param runtimeException 异常
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) throw runtimeException;
    }

    /**
     * 条件成立则抛出异常
     * @param condition 条件
     * @param erroCode 错误码
     */
    public static void throwIf(boolean condition, ErrorCode erroCode) {
        throwIf(condition, new ErrorException(erroCode));
    }

    /**
     * 条件成立则抛出异常
     * @param condition 条件
     * @param erroCode 错误吗
     * @param message 信息
     */
    public static void throwIf(boolean condition, ErrorCode erroCode, String message) {
        throwIf(condition, new ErrorException(erroCode, message));
    }
}
