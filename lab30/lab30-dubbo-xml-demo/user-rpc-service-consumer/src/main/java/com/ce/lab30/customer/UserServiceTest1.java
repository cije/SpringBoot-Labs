package com.ce.lab30.customer;

import com.ce.lab30.api.UserRpcService;
import com.ce.lab30.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cuijie
 * @date 2022/8/3 13:58
 */
@Slf4j
@Component
public class UserServiceTest1 implements CommandLineRunner {

    @Resource
    private UserRpcService userRpcService;

    @Override
    public void run(String... args) throws Exception {
        UserDTO userDTO = userRpcService.get(1);
        log.info("userDTO:{}", userDTO);
    }
}
