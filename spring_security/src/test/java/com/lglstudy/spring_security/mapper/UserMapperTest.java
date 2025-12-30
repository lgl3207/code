package com.lglstudy.spring_security.mapper;

import com.lglstudy.spring_security.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findPasswordByUsername() {
        User smith = userMapper.findPasswordByUsername("smith");
        System.out.println(smith);
    }
}