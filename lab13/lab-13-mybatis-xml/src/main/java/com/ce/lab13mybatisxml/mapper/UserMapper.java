package com.ce.lab13mybatisxml.mapper;

import com.ce.lab13mybatisxml.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author c__e
 * @date Created in 2020/10/11 15:57
 */
@Repository
public interface UserMapper {


    int insert(UserDO user);

    int updateById(UserDO user);

    int deleteById(@Param("id") Integer id);

    UserDO selectById(@Param("id") Integer id);

    UserDO selectByUsername(@Param("username") String username);

    List<UserDO> selectByIds(@Param("ids") Collection<Integer> ids);
}
