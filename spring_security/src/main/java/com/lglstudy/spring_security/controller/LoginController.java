package com.lglstudy.spring_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/user/login")
    public String login(String username, String password) {

        // 非空校验
        if (ObjectUtils.isEmpty(username) || ObjectUtils.isEmpty(password)) {
            return "username and password is null";
        }

        // 封装参数token
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        // 执行认证，认证管理器
        Authentication user = null;
        try {
             user = authenticationManager.authenticate(token);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

        if (user == null) {
            return "用户名或密码不正确";
        }
        // 认证成功，绑定会话
        SecurityContextHolder.getContext().setAuthentication(user);

        return "success";
    }

    @GetMapping("/helloworld")
    public String helloworld() {
        return "HelloWorld!";
    }
}
