package com.lglstudy.spring_security.service.impl;

import com.lglstudy.spring_security.mapper.UserMapper;
import com.lglstudy.spring_security.pojo.MyUserDetails;;
import com.lglstudy.spring_security.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    /**
     * 根据用户名查询用户
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名查询用户信息
        User user = userMapper.findPasswordByUsername(username);

        // 判断是否为null
        if (user == null) {
            System.out.println(username + "用户无法找到");
            throw new BadCredentialsException("用户名或密码错误");
        }

        // 不为null，就将User对象封装到UserDetail中
        MyUserDetails userDetails = new MyUserDetails(user.getUsername(), user.getPassword());

        // 返回
        return userDetails;
    }
}
