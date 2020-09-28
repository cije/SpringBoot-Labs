package com.ce.lab801.controller;

import com.ce.lab801.service.UserService;
import com.ce.lab801.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 基于 Annotated Controller 方式实现
 *
 * @author c__e
 * @date Created in 2020/9/28 14:11
 */
@RestController
@RequestMapping("/users")
public class UserController2 {

    @Autowired
    private UserService userService;

    /**
     * 获得指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/v2/get")
    public Mono<UserVO> get2(@RequestParam("id") Integer id) {
        // 查询用户
        UserVO user = userService.get(id);
        // 返回
        return Mono.just(user);
    }

}