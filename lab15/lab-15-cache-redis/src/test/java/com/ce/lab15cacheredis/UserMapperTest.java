package com.ce.lab15cacheredis;

import com.ce.lab15cacheredis.dataobject.UserDO;
import com.ce.lab15cacheredis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.UUID;

/**
 * @author c__e
 * @date Created in 2020/10/19 14:59
 */
@SpringBootTest(classes = Lab15CacheRedisApplication.class)
@ExtendWith(SpringExtension.class)
public class UserMapperTest {

    private static final String CACHE_NAME_USER = "users";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCacheManager() {
        System.out.println(cacheManager);
    }

    @Test
    public void testSelectById() {
        // 事先已经插入一条 id=1 的记录
        Integer id = 1;

        // 查询id=1 的记录
        UserDO user = userMapper.selectById(id);
        System.out.println("user：" + user);
        // 判断缓存中，是不是存在
        Assert.notNull(cacheManager.getCache(CACHE_NAME_USER).get(user.getId(), UserDO.class),
                "缓存为空");

        user = userMapper.selectById(id);
        System.out.println("user：" + user);
    }

    @Test
    public void testInsert() {
        // 插入记录
        UserDO userDO = new UserDO()
                .setUsername(UUID.randomUUID().toString())
                .setPassword("nicai")
                .setCreateTime(new Date())
                .setDeleted(0);
        userMapper.insert0(userDO);

        // 判断缓存中，是不是存在
        Assert.notNull(cacheManager.getCache(CACHE_NAME_USER).get(userDO.getId(), UserDO.class),
                "缓存为空");
    }

    @Test
    public void testDeleteById() {
        // 插入记录，为了让缓存中有记录
        UserDO userDO = new UserDO()
                .setUsername(UUID.randomUUID().toString())
                .setPassword("nicai")
                .setCreateTime(new Date())
                .setDeleted(0);
        userMapper.insert0(userDO);
        // 判断缓存中，是不是存在
        Assert.notNull(cacheManager.getCache(CACHE_NAME_USER).get(userDO.getId(), UserDO.class),
                "缓存为空");

        // 删除记录
        userMapper.deleteById(userDO.getId());
        // 判断缓存中，是不是存在
        Assert.isNull(cacheManager.getCache(CACHE_NAME_USER).get(userDO.getId(), UserDO.class),
                "缓存不为空");
    }
}
