package com.ce.lab2mapstructdemo.dataobject;

import java.io.Serializable;

/**
 * @author c__e
 * @date Created in 2020/9/19 10:21
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
