package com.lglstudy.spring_security.mapper;

import com.lglstudy.spring_security.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据用户名查询密码
     * @param username
     * @return
     */
    User findPasswordByUsername(@Param("username") String username);
}
