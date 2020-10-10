package com.ce.lab8webflux02.core.web;

import com.ce.lab8webflux02.constants.ServiceExceptionEnum;
import com.ce.lab8webflux02.core.exception.ServiceException;
import com.ce.lab8webflux02.core.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ServerWebInputException;

/**
 * @author c__e
 * @date Created in 2020/9/28 21:58
 */
@ControllerAdvice(basePackages = "com.ce.lab8webflux02.controller")
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理 ServiceException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(ServiceException ex) {
        logger.debug("[serviceExceptionHandler]", ex);
        // 包装 CommonResult 结果
        return CommonResult.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理 ServerWebInputException 异常
     * <p>
     * WebFlux 参数不正确
     */
    @ResponseBody
    @ExceptionHandler(value = ServerWebInputException.class)
    public CommonResult serverWebInputExceptionHandler(ServerWebInputException ex) {
        logger.debug("[ServerWebInputExceptionHandler]", ex);
        // 包装 CommonResult 结果
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    /**
     * 处理其它 Exception 异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(Exception e) {
        // 记录异常日志
        logger.error("[exceptionHandler]", e);
        // 返回 ERROR CommonResult
        return CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
    }

}