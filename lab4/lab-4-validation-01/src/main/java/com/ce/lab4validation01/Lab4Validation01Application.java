package com.ce.lab4validation01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class Lab4Validation01Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab4Validation01Application.class, args);
    }

}
