package com.lglstudy.spring_security.service.impl;

import com.lglstudy.spring_security.mapper.UserMapper;
import com.lglstudy.spring_security.pojo.MyUserDetails;
import com.lglstudy.spring_security.pojo.User;
import com.lglstudy.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findPasswordByUsername(String username) {
        return userMapper.findPasswordByUsername(username);
    }
}
