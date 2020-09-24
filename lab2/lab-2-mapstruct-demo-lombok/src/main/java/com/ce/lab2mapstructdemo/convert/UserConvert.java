package com.ce.lab2mapstructdemo.convert;

import com.ce.lab2mapstructdemo.bo.UserBO;
import com.ce.lab2mapstructdemo.dataobject.UserDO;
import com.ce.lab2mapstructdemo.dataobject.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author c__e
 * @date Created in 2020/9/19 10:25
 */

@Mapper // 添加 @Mapper 注解，声明它是一个 MapStruct Mapper 映射器
public interface UserConvert {
    /**
     * 通过调用 Mappers 的 #getMapper(Class<T> clazz) 方法，获得 MapStruct 帮我们自动生成的 UserConvert 实现类的对象。
     */
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * 声明 UserDO 转换成 UserBO
     */
    UserBO convert(UserDO userDO);

    /**
     * 声明 UserDO 转换成 UserDetail
     */
    @Mappings({
            @Mapping(source = "id", target = "userId")
    })
    UserDetail convertDetail(UserDO userDO);
}
