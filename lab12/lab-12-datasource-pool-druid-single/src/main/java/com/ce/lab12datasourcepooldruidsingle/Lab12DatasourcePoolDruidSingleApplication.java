package com.ce.lab12datasourcepooldruidsingle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class Lab12DatasourcePoolDruidSingleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lab12DatasourcePoolDruidSingleApplication.class, args);
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        logger.info("[run][获得数据源：{}]", dataSource.getClass());
    }
}
