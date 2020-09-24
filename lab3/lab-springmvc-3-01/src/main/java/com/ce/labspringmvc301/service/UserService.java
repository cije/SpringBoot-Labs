package com.ce.labspringmvc301.service;

import com.ce.labspringmvc301.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserVO get(Integer id) {
        return new UserVO().setId(id).setUsername("test");
    }

}
