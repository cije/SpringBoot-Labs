package com.ce.lab30.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cuijie
 * @date 2022/8/3 14:14
 */
@Data
public class UserDTO implements Serializable {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 性别
     */
    private Integer gender;
}
