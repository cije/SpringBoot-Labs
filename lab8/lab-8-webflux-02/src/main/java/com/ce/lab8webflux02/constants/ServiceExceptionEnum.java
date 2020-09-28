package com.ce.lab8webflux02.constants;

/**
 * @author c__e
 * @date Created in 2020/9/28 21:52
 */
public enum ServiceExceptionEnum {
    /**
     * 异常
     */
    SUCCESS(0, "成功"),
    SYS_ERROR(2001001000, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(2001001001, "参数缺失"),

    USER_NOT_FOUND(1001002000, "用户不存在"),
    ;

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String message;

    ServiceExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
