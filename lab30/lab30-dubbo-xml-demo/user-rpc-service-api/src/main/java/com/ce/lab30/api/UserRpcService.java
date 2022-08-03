package com.ce.lab30.api;

import com.ce.lab30.dto.UserAddDTO;
import com.ce.lab30.dto.UserDTO;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

/**
 * @author cuijie
 * @date 2022/8/3 9:48
 */
public interface UserRpcService {

    /**
     * 根据指定用户编号，获取用户信息
     *
     * @param id 用户编号
     * @return 用户信息
     */
    UserDTO get(@NotNull(message = "用户编号不能为空") Integer id) throws ConstraintViolationException;

    /**
     * 添加新用户，返回新添加的用户编号
     *
     * @param addDTO 添加的用户信息
     * @return 用户编号
     */
    Integer add(UserAddDTO addDTO) throws ConstraintViolationException;
}
