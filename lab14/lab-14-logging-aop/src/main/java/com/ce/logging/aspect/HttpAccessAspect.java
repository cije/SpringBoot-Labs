package com.ce.logging.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author c__e
 * @date Created in 2020/10/18 19:51
 */
@Aspect
@Component
public class HttpAccessAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Around("@within(org.springframework.web.bind.annotation.RestController)" +
            "||@within(org.springframework.stereotype.Controller)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 获取类名
        String className = point.getTarget().getClass().getName();
        // 获取方法
        String methodName = point.getSignature().getName();
        // 记录开始时间
        long beginTime = System.currentTimeMillis();
        // 记录返回结果
        Object result = null;
        Exception ex = null;
        try {
            // 执行方法
            result = point.proceed();
            return result;
        } catch (Exception e) {
            // 记录异常
            ex = e;
            throw e;
        } finally {
            // 计算消耗时间
            long costTime = System.currentTimeMillis() - beginTime;
            // 发生异常，则打印 ERROR 日志
            if (ex != null) {
                logger.error("[className：{}][methodName：{}][cost：{} ms][args：{}][发生异常：{}]",
                        className, methodName, costTime, point.getArgs(), ex);
            } else {
                // 正常执行，则打印 INFO 日志
                logger.info("[className：{}][methodName：{}][cost：{} ms][args：{}][return：{}]",
                        className, methodName, costTime, point.getArgs(), result);
            }
        }
    }
}
