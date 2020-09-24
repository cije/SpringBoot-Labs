package com.ce.labspringmvc302.core.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author c__e
 * @date Created in 2020/9/22 9:30
 */
@WebFilter(urlPatterns = "/test/*")
public class TestFilter02 implements Filter {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("[doFilter]");
        chain.doFilter(request, response);
    }
}
