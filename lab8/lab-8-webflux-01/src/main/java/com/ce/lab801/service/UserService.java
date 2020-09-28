package com.ce.lab801.service;

import com.ce.lab801.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author c__e
 * @date Created in 2020/9/28 15:13
 */
@Service
public class UserService {

    public UserVO get(Integer id) {
        return new UserVO().setId(id).setUsername("test");
    }

}