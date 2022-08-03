package com.ce.lab30;

import com.ce.lab30.dto.UserDTO;
import com.ce.lab30.service.UserRpcService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author cuijie
 * @date 2022/8/3 14:30
 */
@Slf4j
@Component
public class UserRpcServiceTest1 implements CommandLineRunner {

    @Reference(version = "${dubbo.consumer.UserRpcService.version}")
    private UserRpcService userRpcService;

    @Override
    public void run(String... args) throws Exception {
        UserDTO user = userRpcService.get(1);
        log.info("[run][发起一次 Dubbo RPC 请求，获得用户为({})", user);
    }

}
