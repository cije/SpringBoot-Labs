package com.ce.lab4validation01.config;

import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

/**
 * @author c__e
 * @date Created in 2020/9/24 19:20
 */
@Configuration
public class ValidationConfiguration {
    /**
     * @return Validator对象
     */
    @Bean
    public Validator validator(MessageSource messageSource) {
        // 创建LocalValidatorFactoryBean
        LocalValidatorFactoryBean validator = ValidationAutoConfiguration.defaultValidator();
        // 设置messageSource属性，实现i18国际化
        validator.setValidationMessageSource(messageSource);
        // 返回
        return validator;
    }
}
