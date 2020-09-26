package com.ce.lab601.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author c__e
 * @date Created in 2020/9/26 9:20
 */
@Configuration
public class WebSocketConfiguration {
    /**
     * 该 Bean 的作用，是扫描添加有 @ServerEndpoint 注解的 Bean
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
