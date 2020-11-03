package com.vegt.mapper;
import com.vegt.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    //登录用户
    user Sel (@Param("username") String username, @Param("password") String password );

    //查询新增的用户是否存在
    user getuser(@Param("username") String username);
    //新增用户
    Integer Adduser(user user);
}
