package com.bitspark.exception;

import lombok.Getter;

/**
 * @Datetime: 2024年12月14日14:19
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.exception
 * @Project: BitSpark-Share-Backend
 * @Description:
 */
@Getter
public class ErrorException extends RuntimeException{
    /**
     * 错误码
     */
    private final int code;

    public ErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorException (ErrorCode code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

    public ErrorException (ErrorCode code, String message) {
        super(message);
        this.code = code.getCode();
    }

}
