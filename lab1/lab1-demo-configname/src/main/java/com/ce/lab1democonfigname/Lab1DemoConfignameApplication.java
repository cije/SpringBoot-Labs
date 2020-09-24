package com.ce.lab1democonfigname;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Lab1DemoConfignameApplication {

    /**
     * 设置需要读取的配置文件的名字。
     * 基于 {@link org.springframework.boot.context.config.ConfigFileApplicationListener#CONFIG_NAME_PROPERTY} 实现。
     */
    private static final String CONFIG_NAME_VALUE = "application,rpc";

    public static void main(String[] args) {
        // <X> 设置环境变量
        System.setProperty(ConfigFileApplicationListener.CONFIG_NAME_PROPERTY, CONFIG_NAME_VALUE);
        SpringApplication.run(Lab1DemoConfignameApplication.class, args);
    }

    @Component
    public class ValueCommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Value("${application-test}")
        private String applicationTest;

        @Value("${rpc-test}")
        private String rpcTest;

        @Override
        public void run(String... args) throws Exception {
            logger.info("application：" + applicationTest);
            logger.info("rpc：" + rpcTest);
        }
    }

}
