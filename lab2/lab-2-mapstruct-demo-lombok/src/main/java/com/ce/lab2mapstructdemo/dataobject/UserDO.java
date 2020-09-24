package com.ce.lab2mapstructdemo.dataobject;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author c__e
 * @date Created in 2020/9/19 10:21
 */
@Data
@Accessors(chain = true)
public class UserDO implements Serializable {
    /**
     * 用户编号
     **/
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
