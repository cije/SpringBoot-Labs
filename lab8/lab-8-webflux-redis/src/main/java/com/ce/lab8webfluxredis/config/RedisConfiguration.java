package com.ce.lab8webfluxredis.config;

import com.ce.lab8webfluxredis.cacheobject.UserCacheObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author c__e
 * @date Created in 2020/9/29 14:54
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public ReactiveRedisTemplate<String, Object> commonRedisTemplate(ReactiveRedisConnectionFactory factory) {
        RedisSerializationContext<String, Object> serializationContext =
                RedisSerializationContext.<String, Object>newSerializationContext(RedisSerializer.string())
                        // 创建通用的 GenericJackson2JsonRedisSerializer 作为序列化
                        .value(RedisSerializer.json())
                        .build();
        return new ReactiveRedisTemplate<>(factory, serializationContext);
    }

    @Bean
    public ReactiveRedisTemplate<String, UserCacheObject> userRedisTemplate(ReactiveRedisConnectionFactory factory) {
        RedisSerializationContext<String, UserCacheObject> serializationContext =
                RedisSerializationContext.<String, UserCacheObject>newSerializationContext(RedisSerializer.string())
                        // 创建专属 UserCacheObject 的 Jackson2JsonRedisSerializer 作为序列化
                        .value(new Jackson2JsonRedisSerializer<>(UserCacheObject.class))
                        .build();
        return new ReactiveRedisTemplate<>(factory, serializationContext);
    }
}
