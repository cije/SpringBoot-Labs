package com.ce.lab2mapstructdemo;

import com.ce.lab2mapstructdemo.bo.UserBO;
import com.ce.lab2mapstructdemo.convert.UserConvert;
import com.ce.lab2mapstructdemo.dataobject.UserDO;
import com.ce.lab2mapstructdemo.dataobject.UserDetail;

/**
 * @author c__e
 * @date Created in 2020/9/19 10:28
 */
public class UserBOTest {
    public static void main(String[] args) {
        // 创建UserDO对象
        UserDO userDO = new UserDO().setId(1).setUsername("张三").setPassword("123456");

        // 进行封装
        UserBO userBo = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBo);

        UserDetail userDetail = UserConvert.INSTANCE.convertDetail(userDO);
        System.out.println(userDetail);
    }
}
