package com.ce.lab13mybatisannotation;

import com.ce.lab13mybatisannotation.dataobject.UserDO;
import com.ce.lab13mybatisannotation.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author c__e
 * @date Created in 2020/10/11 16:18
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void testInset() {
        UserDO userDO = new UserDO().setUsername(UUID.randomUUID().toString())
                .setPassword("nicai").setCreateTime(new Date());
        mapper.insert(userDO);
    }

    @Test
    public void testUpdateById() {
        UserDO updateUser = new UserDO().setId(1).setPassword("wobucai");
        mapper.updateById(updateUser);
    }

    @Test
    public void testDeleteById() {
        mapper.deleteById(2);
    }

    @Test
    public void testSelectById() {
        UserDO userDO = mapper.selectById(1);
        System.out.println(userDO.getUsername() + " " + userDO.getPassword());
    }

    @Test
    public void testSelectByIds() {
        List<UserDO> userDOS = mapper.selectByIds(Arrays.asList(1, 2, 3));
        userDOS.forEach(userdao -> System.out.println(userdao.getUsername()));
    }
}
