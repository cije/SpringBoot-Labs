package com.ce.lab30.provider.service;

import com.ce.lab30.api.UserRpcService;
import com.ce.lab30.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author cuijie
 * @date 2022/8/3 11:34
 */
@Service
public class UserRpcServiceImpl implements UserRpcService {
    @Override
    public UserDTO get(Integer id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName("没有昵称：" + id);
        // 1-男 2-女
        userDTO.setGender(id % 2 + 1);
        return userDTO;
    }
}
