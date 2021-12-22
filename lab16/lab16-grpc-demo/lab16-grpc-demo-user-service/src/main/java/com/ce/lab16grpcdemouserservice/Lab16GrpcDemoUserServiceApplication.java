package com.ce.lab16grpcdemouserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Lab16GrpcDemoUserServiceApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Lab16GrpcDemoUserServiceApplication.class, args);
        // 阻塞，避免应用退出
        new CountDownLatch(1).await();
    }

}
