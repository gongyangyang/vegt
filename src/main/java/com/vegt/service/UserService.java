package com.vegt.service;

import com.vegt.entity.user;
import com.vegt.service.exception.InsertException;
import com.vegt.service.exception.PasswordNotMatchException;
import com.vegt.service.exception.UserDuplicateException;
import com.vegt.service.exception.UserNotFoundException;
import org.apache.ibatis.annotations.Param;




public interface UserService {
    //实现层用户登录
    user Sel(@Param("username") String username, @Param("password") String password) throws UserNotFoundException, PasswordNotMatchException;

    //实现层用户注册
     void  InserUser(user user) throws UserDuplicateException, InsertException;
}
