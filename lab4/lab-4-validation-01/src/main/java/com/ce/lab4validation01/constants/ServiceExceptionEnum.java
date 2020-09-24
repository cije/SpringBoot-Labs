package com.ce.lab4validation01.constants;

import lombok.Getter;

/**
 * @author c__e
 * @date Created in 2020/9/21 17:11
 */
@Getter
public enum ServiceExceptionEnum {
    // ========== 系统级别 ==========
    SUCCESS(0, "成功"),
    SYS_ERROR(2001001000, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(2001001001, "参数缺失"),

    // ========== 用户模块 ==========
    USER_NOT_FOUND(1001002000, "用户不存在"),

    INVALID_REQUEST_PARAM_ERROR(2001001002, "请求参数不合法"),
    ;

    /**
     * 错误码
     */
    private int code;
    /**
     * 错误提示
     */
    private String message;

    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
