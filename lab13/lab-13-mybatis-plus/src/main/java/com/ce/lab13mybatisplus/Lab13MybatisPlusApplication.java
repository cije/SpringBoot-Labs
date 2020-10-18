package com.ce.lab13mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ce.lab13mybatisplus.mapper")
public class Lab13MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab13MybatisPlusApplication.class, args);
    }

}
