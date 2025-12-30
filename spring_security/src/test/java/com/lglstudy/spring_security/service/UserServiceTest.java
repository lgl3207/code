package com.lglstudy.spring_security.service;

import com.lglstudy.spring_security.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void findPasswordByUsername() {
        User admin = userService.findPasswordByUsername("smith");
        System.out.println(admin);
    }
}