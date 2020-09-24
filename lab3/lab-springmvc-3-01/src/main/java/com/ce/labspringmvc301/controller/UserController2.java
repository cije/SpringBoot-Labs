package com.ce.labspringmvc301.controller;

import com.ce.labspringmvc301.dto.UserAddDTO;
import com.ce.labspringmvc301.dto.UserUpdateDTO;
import com.ce.labspringmvc301.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author c__e
 * @date Created in 2020/9/19 12:38
 */
@RestController
@RequestMapping("/users2")
public class UserController2 {
    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    @GetMapping("/list")
    public List<UserVO> list() {
        // 查询列表
        List<UserVO> list = new ArrayList<>();
        list.add(new UserVO().setId(1).setUsername("lalal1"));
        list.add(new UserVO().setId(2).setUsername("lalal2"));
        list.add(new UserVO().setId(3).setUsername("lalal3"));
        // 返回列表
        return list;
    }

    /**
     * 查询指定用户编号的用户
     *
     * @param id 用户编号
     * @return 用户
     */
    @GetMapping("/get")
    public UserVO get(Integer id) {
        // 查询并返回用户
        return new UserVO().setId(id).setUsername("username" + id);
    }

    /**
     * 添加用户
     *
     * @param addDTO 添加用户信息 DTO
     * @return 添加成功的用户编号
     */
    @PostMapping("/add")
    public Integer add(UserAddDTO addDTO) {
        // 插入用户记录，返回编号
        Integer returnId = 1;
        // 返回用户编号
        return returnId;
    }

    /**
     * 更新指定用户编号的用户
     *
     * @param updateDTO 更新用户信息 DTO
     * @return 是否修改成功
     */
    @PostMapping("/update")
    public Boolean update(UserUpdateDTO updateDTO) {
        // 更新用户记录
        Boolean success = true;
        // 返回更新是否成功
        return success;
    }

    /**
     * 删除指定用户编号的用户
     *
     * @param id 用户编号
     * @return 是否删除成功
     */
    @DeleteMapping("/delete")
    public Boolean delete(@RequestParam("id") Integer id) {
        // 删除用户记录
        Boolean success = false;
        // 返回是否更新成功
        return success;
    }

}
