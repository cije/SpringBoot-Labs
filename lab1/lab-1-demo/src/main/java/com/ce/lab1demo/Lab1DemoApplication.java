package com.ce.lab1demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Lab1DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1DemoApplication.class, args);
    }

    @Component
    public static class OrderPropertiesCommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        private OrderProperties orderProperties;

        /**
         * Spring4.x 以后，推荐使用构造函数的形式注入属性
         */
        @Autowired
        public OrderPropertiesCommandLineRunner(OrderProperties orderProperties) {
            this.orderProperties = orderProperties;
        }

        @Override
        public void run(String... args) throws Exception {
            logger.info("订单支付超时时长：" + orderProperties.getPayTimeoutSeconds());
            logger.info("订单创建频率：" + orderProperties.getCreateFrequencySeconds());
        }
    }

    @Component
    public static class OrderProperties1CommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        private final Person person;

        /**
         * Spring4.x 以后，推荐使用构造函数的形式注入属性
         */
        @Autowired
        public OrderProperties1CommandLineRunner(Person person) {
            this.person = person;
        }

        @Override
        public void run(String... args) throws Exception {
            logger.info("name：" + person.getName());
            logger.info("age：" + person.getAge());
        }
    }

    @Component
    public static class ValueCommandLineRunner implements CommandLineRunner {

        private final Logger logger = LoggerFactory.getLogger(getClass());

        @Value("${order.pay-timeout-seconds}")
        private Integer payTimeoutSeconds;
        @Value("${order.create-frequency-seconds}")
        private Integer createFrequencySeconds;

        @Override
        public void run(String... args) throws Exception {
            logger.info("订单支付超时时长：" + payTimeoutSeconds);
            logger.info("订单创建频率：" + createFrequencySeconds);
        }
    }
}
