package com.ce.lab12datasourcepoolhikaricpmultiple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class Lab12DatasourcePoolHikaricpMultipleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lab12DatasourcePoolHikaricpMultipleApplication.class, args);
    }


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "ordersDataSource")
    private DataSource ordersDataSource;
    @Resource(name = "usersDataSource")
    private DataSource usersDataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = ordersDataSource.getConnection()) {
            logger.info("[run][ordersDataSource 获得连接 {}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = usersDataSource.getConnection()) {
            logger.info("[run][usersDataSource 获得连接 {}]", conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
