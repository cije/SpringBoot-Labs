package com.ce.labspringmvc302.core.expection;

import com.ce.labspringmvc302.constants.ServiceExceptionEnum;
import lombok.Getter;

/**
 * @author c__e
 * @date Created in 2020/9/21 17:14
 */
@Getter
public class ServiceException extends RuntimeException {
    /**
     * 错误码
     */
    private final Integer code;

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        // 使用父类的 message 字段
        super(serviceExceptionEnum.getMessage());
        // 设置错误码
        this.code = serviceExceptionEnum.getCode();
    }
}
