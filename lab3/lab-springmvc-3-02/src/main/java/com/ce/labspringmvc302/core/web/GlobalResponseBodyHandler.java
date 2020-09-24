package com.ce.labspringmvc302.core.web;

import com.ce.labspringmvc302.core.vo.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author c__e
 * @date Created in 2020/9/21 16:38
 */
@ControllerAdvice(basePackages = "com.ce.labspringmvc302.controller")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 表示拦截 Controller 所有 API 接口的返回结果
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 如果已经是 CommonResult 类型，则直接返回
        if (body instanceof CommonResult) {
            return body;
        } else {
            // 如果不是，则包装为CommonResult
            return CommonResult.success(body);
        }
    }
}
