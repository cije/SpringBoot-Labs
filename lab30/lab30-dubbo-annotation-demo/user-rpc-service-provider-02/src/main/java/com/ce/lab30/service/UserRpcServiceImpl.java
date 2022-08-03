package com.ce.lab30.service;

import com.ce.lab30.dto.UserDTO;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author cuijie
 * @date 2022/8/3 14:18
 */
@DubboService(version = "${dubbo.provider.UserRpcService.version}")
public class UserRpcServiceImpl implements UserRpcService {
    @Override
    public UserDTO get(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName("name" + id);
        userDTO.setGender(id % 2 + 1);
        return userDTO;
    }
}
