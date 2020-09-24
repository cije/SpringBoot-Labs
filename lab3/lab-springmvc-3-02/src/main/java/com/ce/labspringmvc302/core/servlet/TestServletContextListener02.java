package com.ce.labspringmvc302.core.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author c__e
 * @date Created in 2020/9/22 9:41
 */
@WebListener
public class TestServletContextListener02 implements ServletContextListener {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("[contextInitialized]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}