package com.lglstudy.spring_security.service;

import com.lglstudy.spring_security.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     * 根据用户名查询密码
     * @param username
     * @return
     */
    User findPasswordByUsername(@Param("username") String username);
}
