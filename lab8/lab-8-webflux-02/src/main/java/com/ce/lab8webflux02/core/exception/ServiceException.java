package com.ce.lab8webflux02.core.exception;

import com.ce.lab8webflux02.constants.ServiceExceptionEnum;

/**
 * @author c__e
 * @date Created in 2020/9/28 21:54
 */
public class ServiceException extends RuntimeException {
    /**
     * 错误码
     */
    private final Integer code;


    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类的错误提示
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
