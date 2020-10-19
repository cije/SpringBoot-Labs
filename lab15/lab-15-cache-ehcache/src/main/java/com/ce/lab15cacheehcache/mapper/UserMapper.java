package com.ce.lab15cacheehcache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ce.lab15cacheehcache.dataobject.UserDO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author c__e
 * @date Created in 2020/10/19 14:47
 */
@Repository
@CacheConfig(cacheNames = "users")
public interface UserMapper extends BaseMapper<UserDO> {

    @Cacheable(key = "#id")
    UserDO selectById(Integer id);

    @CachePut(key = "#user.id")
    default UserDO insert0(UserDO user) {
        // 插入记录
        this.insert(user);
        // 返回用户
        return user;
    }

    @CacheEvict(key = "#id")
    int deleteById(Integer id);
}
