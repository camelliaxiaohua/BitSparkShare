package com.bitspark.common;

import com.bitspark.exception.ErrorCode;
import io.swagger.annotations.Api;

   /**
 * @Datetime: 2024年12月14日14:49
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.common
 * @Project: BitSpark-Share-Backend
 * @Description: 响应结果工具类
 */
public class ApiUtils {


    /**
     * 成功
     * @param data 数据
     * @return 响应
     * @param <T> 数据类型
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200,data,"成功");
    }

    /**
     * 失败
     * @param errorCode 错误码
     * @return 响应
     */
    public static ApiResponse<?> error(ErrorCode errorCode) {
        return new ApiResponse<>(errorCode);
    }

    /**
     * 失败
     * @param code 错误码
     * @param message 错误消息
     * @return 响应
     */
    public static ApiResponse<?> error(int code, String message) {
        return new ApiResponse<>(code, message);
    }

    /**
     * 失败
     * @param errorCode 错误码
     * @param message 消息
     * @return 响应
     */
    public static ApiResponse<?> error(ErrorCode errorCode, String message) {
        return new ApiResponse<>(errorCode.getCode(), null, message);
    }
}
