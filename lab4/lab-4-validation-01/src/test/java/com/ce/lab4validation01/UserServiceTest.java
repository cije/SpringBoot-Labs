package com.ce.lab4validation01;

import com.ce.lab4validation01.dto.UserAddDTO;
import com.ce.lab4validation01.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author c__e
 * @date Created in 2020/9/24 9:19
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Lab4Validation01Application.class)
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    public void testGet() {
        service.get(-1);
    }

    @Test
    public void testGet2() {
        service.get(1);
    }

    @Test
    public void testAdd() {
        UserAddDTO addDTO = new UserAddDTO();
        service.add(addDTO);
    }

    @Test
    public void testAdd01() {
        UserAddDTO addDTO = new UserAddDTO();
        service.add01(addDTO);
    }

    @Test
    public void testAdd02() {
        UserAddDTO addDTO = new UserAddDTO();
        service.add02(addDTO);
    }
}
