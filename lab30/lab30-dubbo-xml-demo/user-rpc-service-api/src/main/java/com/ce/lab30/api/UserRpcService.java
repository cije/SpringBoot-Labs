package com.ce.lab30.api;

import com.ce.lab30.dto.UserDTO;

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
    UserDTO get(Integer id);
}
