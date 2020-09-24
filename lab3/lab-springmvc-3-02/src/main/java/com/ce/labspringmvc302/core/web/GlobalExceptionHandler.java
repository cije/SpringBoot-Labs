package com.ce.labspringmvc302.core.web;

import com.ce.labspringmvc302.constants.ServiceExceptionEnum;
import com.ce.labspringmvc302.core.expection.ServiceException;
import com.ce.labspringmvc302.core.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author c__e
 * @date Created in 2020/9/21 23:04
 */
@ControllerAdvice(basePackages = "com.ce.labspringmvc302.controller")
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理ServiceException异常
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest request, ServiceException ex) {
        logger.debug("[serviceExceptionHandler]", ex);
        // 包装CommonResult结果
        return CommonResult.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理MissingServletRequestParameterException异常
     */
    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException ex) {
        logger.debug("[missingServletRequestParameterExceptionHandler]", ex);
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(), ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    /**
     * 处理其他异常
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest request, Exception ex) {
        logger.debug("[exceptionHandler", ex);
        return CommonResult.error(ServiceExceptionEnum.SYS_ERROR.getCode(), ServiceExceptionEnum.SYS_ERROR.getMessage());
    }
}
