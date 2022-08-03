package com.ce.lab30.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author cuijie
 * @date 2022/8/3 13:53
 */
@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
