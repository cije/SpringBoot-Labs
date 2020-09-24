package com.ce.labspringmvc302.core.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author c__e
 * @date Created in 2020/9/22 9:27
 */
@WebServlet(urlPatterns = "/test/02")
public class TestServlet02 extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("[doGet][uri：{}]", req.getRequestURI());
    }
}
