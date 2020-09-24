package com.ce.labspringmvc301;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Objects;

/**
 * MockMvc 集成测试
 *
 * @author c__e
 * @date Created in 2020/9/19 14:55
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LabSpringmvc301Application.class)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testList() throws Exception {
        // 查询用户列表
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/users"));
        // 校验结果
        // 响应状态码 200
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        // 响应结果
        resultActions.andExpect(MockMvcResultMatchers.content().json("[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"username\": \"lalal1\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"username\": \"lalal2\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"username\": \"lalal3\"\n" +
                "    }\n" +
                "]"));
    }

    @Test
    public void testGet() throws Exception {
        // 获取指定用户编号的用户
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/users/1"));
        // 校验结果
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.content().json("{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"username1\"\n" +
                "}"));
        // 打印结果
        resultActions.andDo(MockMvcResultHandlers.print());

        // 获得MvcResult，后续执行各种自定义逻辑
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("拦截器数量：" + Objects.requireNonNull(mvcResult.getInterceptors()).length);

    }

    @Test
    public void testAdd() throws Exception {
        // 添加用户
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/users")
                .param("username", "lalala")
                .param("password", "aaa"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.content().string("1"));
    }
    @Test
    public void testUpdate() throws Exception {
        // 添加用户
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.put("/users/1")
                .param("username", "lalala")
                .param("password", "aaa"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.content().string("true"));
    }
    @Test
    public void testDelete() throws Exception {
        // 添加用户
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.delete("/users/1"));
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.content().string("false"));
    }
}
