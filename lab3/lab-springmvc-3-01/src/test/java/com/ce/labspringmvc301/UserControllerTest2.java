package com.ce.labspringmvc301;

import com.ce.labspringmvc301.controller.UserController;
import com.ce.labspringmvc301.service.UserService;
import com.ce.labspringmvc301.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author c__e
 * @date Created in 2020/9/21 15:13
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest2 {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService service;

    @Test
    public void testGet2() throws Exception {
        // Mock UserService 的get方法
        System.out.println("before mock：" + service.get(1));
        Mockito.when(service.get(1)).thenReturn(new UserVO().setId(1).setUsername("username:1"));
        System.out.println("after mock:" + service.get(1));

        // 查询用户列表
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/users/v2/1"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.content().json("{\n" +
                "    \"id\":1,\n" +
                "    \"username\":\"username:1\"\n" +
                "}"));

    }

}
