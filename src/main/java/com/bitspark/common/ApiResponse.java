package com.bitspark.common;

import com.bitspark.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @Datetime: 2024年12月14日14:41
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.common
 * @Project: BitSpark-Share-Backend
 * @Description:
 */
@Data
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 4066075683089980273L;

    private int code;

    private T data;

    private String message;

    public ApiResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ApiResponse(int code, T data) {
        this(code, data, "");
    }

    public ApiResponse(ErrorCode errorCode) {
        this(errorCode.getCode(),null,errorCode.getMessage());
    }
}
