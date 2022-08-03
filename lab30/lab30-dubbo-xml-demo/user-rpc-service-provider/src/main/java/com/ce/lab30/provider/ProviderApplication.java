package com.ce.lab30.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author cuijie
 * @date 2022/8/3 10:15
 */
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
