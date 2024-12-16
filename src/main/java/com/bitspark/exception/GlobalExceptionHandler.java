package com.bitspark.exception;

import com.bitspark.common.ApiResponse;
import com.bitspark.common.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Datetime: 2024年12月16日21:47
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.exception
 * @Project: BitSpark-Share-Backend
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ErrorException.class)
    public ApiResponse<?> errorExceptionHandler(ErrorException e){
        log.error("errorExceptionHandler: {}", e);
        return ApiUtils.error(e.getCode(), e.getMessage());
    }

    /**
     * 默认异常处理器,系统异常处理。
     * @param e
     * @return
     */
    @ExceptionHandler
    public ApiResponse<?> errorExceptionHandler(RuntimeException e){
        log.error("defaultExceptionHandler: {}", e);
        return ApiUtils.error(ErrorCode.SERVER_ERROR,"系统错误");
    }
}
