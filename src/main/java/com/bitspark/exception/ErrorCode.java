package com.bitspark.exception;

import lombok.Getter;

/**
 * @Datetime: 2024年12月11日22:50
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.exception
 * @Project: BitSpark-Share-Backend
 * @Description: 错误码枚举类，包含错误码、消息及更多细节
 */
@Getter
public enum ErrorCode {

    // 1xx - 信息性响应
    INFO_CONTINUE(100, "继续"),
    INFO_SWITCHING_PROTOCOLS(101, "切换协议"),

    // 2xx - 成功
    SUCCESS(200, "成功"),
    CREATED(201, "已创建"),
    ACCEPTED(202, "已接受"),

    // 3xx - 重定向
    MOVED_PERMANENTLY(301, "永久移动"),
    FOUND(302, "临时移动"),

    // 4xx - 客户端错误
    PARAM_ERROR(400, "参数错误"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "找不到资源"),
    METHOD_NOT_ALLOWED(405, "方法不被允许"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "请求冲突"),
    GONE(410, "资源已删除"),
    PAYLOAD_TOO_LARGE(413, "请求负载过大"),
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的媒体类型"),

    // 5xx - 服务器错误
    SERVER_ERROR(500, "服务器错误"),
    BAD_GATEWAY(502, "错误的网关"),
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    GATEWAY_TIMEOUT(504, "网关超时"),

    // 自定义错误
    DATABASE_ERROR(1001, "数据库错误"),
    INTERNAL_SERVER_ERROR(1002, "内部服务器错误"),
    AUTHENTICATION_FAILED(1003, "认证失败"),
    RESOURCE_NOT_FOUND(1004, "资源未找到");

    private final int code;
    private final String message;
    private final String status;

    // 构造函数
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
        this.status = determineStatus(code);
    }

    /**
     * 根据错误码确定错误类型
     * @param code 错误码
     * @return 错误类型 (SUCCESS, CLIENT_ERROR, SERVER_ERROR, INFO, REDIRECT)
     */
    private String determineStatus(int code) {
        if (code >= 200 && code < 300) {
            return "SUCCESS";
        } else if (code >= 400 && code < 500) {
            return "CLIENT_ERROR";
        } else if (code >= 500 && code < 600) {
            return "SERVER_ERROR";
        } else if (code >= 100 && code < 200) {
            return "INFO";
        } else if (code >= 300 && code < 400) {
            return "REDIRECT";
        }
        return "UNKNOWN";
    }

    /**
     * 获取错误码的详细信息（带状态和消息）
     * @return 错误码、状态和消息的组合
     */
    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    /**
     * 获取错误消息
     * @param code 错误码
     * @return 错误消息，如果未找到，返回null
     */
    public static String getMessageByCode(int code) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.code == code) {
                return errorCode.message;
            }
        }
        return null;
    }

    /**
     * 获取统一的错误响应格式
     * @param code 错误码
     * @param additionalMessage 附加消息（可选）
     * @return 格式化的错误响应
     */
    public static String getErrorResponse(int code, String additionalMessage) {
        String message = getMessageByCode(code);
        return String.format("Error: {code: %d, message: '%s', details: '%s'}",
                code, message != null ? message : "未知错误", additionalMessage != null ? additionalMessage : "无详细信息");
    }

    /**
     * 获取错误的详细信息并包装成 JSON 响应格式
     * @param code 错误码
     * @param additionalMessage 附加消息
     * @return JSON 格式错误响应
     */
    public static String getJsonErrorResponse(int code, String additionalMessage) {
        String message = getMessageByCode(code);
        return String.format("{\"error\": {\"code\": %d, \"message\": \"%s\", \"details\": \"%s\"}}",
                code, message != null ? message : "未知错误", additionalMessage != null ? additionalMessage : "无详细信息");
    }
}
