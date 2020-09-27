package com.ce.distributedsession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * (@EnableRedisHttpSession) 自动化配置 Spring Session 使用 Redis 作为数据源
 *
 * @author c__e
 * @date Created in 2020/9/26 20:01
 */
@Configuration
@EnableRedisHttpSession
public class SessionConfiguration {
    /**
     * 创建 RedisOperationsSessionRepository 使用的 RedisSerializer Bean 。
     * <p>
     *
     * @return RedisSerializer Bean
     */
    @Bean(name = "springSessionDefaultRedisSerializer")
    public RedisSerializer<Object> springSessionDefaultRedisSerializer() {
        return RedisSerializer.json();
    }
}
