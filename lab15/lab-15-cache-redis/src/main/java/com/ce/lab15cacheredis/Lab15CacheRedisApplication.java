package com.ce.lab15cacheredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.ce.lab15cacheredis")
public class Lab15CacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab15CacheRedisApplication.class, args);
    }

}
