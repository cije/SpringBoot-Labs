package com.ce.lab12datasourcepooldruidmultiple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootApplication
public class Lab12DatasourcePoolDruidMultipleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lab12DatasourcePoolDruidMultipleApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;

    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;


    @Override
    public void run(String... args) throws Exception {
        logger.info("[run][获得数据源：{}]", ordersDataSource.getClass());
        logger.info("[run][获得数据源：{}]", usersDataSource.getClass());
    }
}
