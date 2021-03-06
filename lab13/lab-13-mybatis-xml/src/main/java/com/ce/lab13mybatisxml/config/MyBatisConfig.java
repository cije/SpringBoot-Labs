package com.ce.lab13mybatisxml.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author c__e
 * @date Created in 2020/10/11 15:46
 */
@Configuration
@MapperScan(basePackages = "com.ce.lab13mybatisxml.mapper")
public class MyBatisConfig {
}
