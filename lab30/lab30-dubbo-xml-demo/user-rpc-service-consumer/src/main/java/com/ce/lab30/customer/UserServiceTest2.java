package com.ce.lab30.customer;

import com.ce.lab30.api.UserRpcService;
import com.ce.lab30.dto.UserAddDTO;
import com.ce.lab30.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cuijie
 * @date 2022/8/3 14:44
 */
@Slf4j
@Component
public class UserServiceTest2 implements CommandLineRunner {

    @Resource
    private UserRpcService userRpcService;


    @Override
    public void run(String... args) throws Exception {
        // 获得用户
        try {
            // 发起调用 故意传入空的编号，为了校验编号不通过
            UserDTO user = userRpcService.get(null);
            log.info("[run][发起一次 Dubbo RPC 请求，获得用户为({})]", user);
        } catch (Exception e) {
            log.error("[run][获得用户发生异常，信息为:[{}]", e.getMessage());
        }

        // 添加用户
        try {
            // 创建 UserAddDTO
            UserAddDTO addDTO = new UserAddDTO();
            // 故意把名字打的特别长，为了校验名字不通过
            addDTO.setName("yudaoyuanmayudaoyuanma");
            // 不传递性别，为了校验性别不通过
            addDTO.setGender(null);
            // 发起调用
            userRpcService.add(addDTO);
            log.info("[run][发起一次 Dubbo RPC 请求，添加用户为({})]", addDTO);
        } catch (Exception e) {
            log.error("[run][添加用户发生异常，信息为:[{}]", e.getMessage());
        }
    }
}
