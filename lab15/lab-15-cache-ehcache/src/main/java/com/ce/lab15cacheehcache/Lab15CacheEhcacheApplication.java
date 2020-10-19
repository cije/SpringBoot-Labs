package com.ce.lab15cacheehcache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.ce.lab15cacheehcache.mapper")
public class Lab15CacheEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab15CacheEhcacheApplication.class, args);
    }

}
