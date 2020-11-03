package com.vegt.service.serviceImpl;
import com.vegt.entity.user;
import com.vegt.mapper.UserMapper;
import com.vegt.service.UserService;
import com.vegt.service.exception.InsertException;
import com.vegt.service.exception.PasswordNotMatchException;
import com.vegt.service.exception.UserDuplicateException;
import com.vegt.service.exception.UserNotFoundException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    user us = new user();

    public user Sel(@Param("username") String username, @Param("password") String password)
            throws UserNotFoundException, PasswordNotMatchException {
            us = userMapper.getuser(username);
            if (us==null) {
                throw new UserNotFoundException("~亲~，您登录的用户不存在或用户名密码错误;请输入正确的用户名和密码");
            }
            String salt = us.getSalt();
            password = getmd5password(password,salt);
            String sqlpassword = us.getPassword();
            if(!password.equals(sqlpassword)) {
                throw new PasswordNotMatchException("~亲~,密码错误,请输入正确的密码");
            }
        System.out.println("salt:"+salt);
        return us;
    }

    @Override
    public void InserUser(user user) throws UserDuplicateException, InsertException {
        String username = user.getUsername();
        System.out.println("用户名："+user.getUsername());
        user us= userMapper.getuser(username);
        System.out.println("us:"+us);
        if(username==null || username==""){
            throw new InsertException("用户名或密码不能为空");
        }
        if(us!=null){
            throw new UserDuplicateException("该用户已存在");
        }
        //补全数据
        String salt = UUID.randomUUID().toString();
        user.setSalt(salt);
        //获取用户密码
        String password = user.getPassword();
        String md5password = getmd5password(password,salt);
        user.setPassword(md5password);
        System.out.println("user"+user);
        Integer row = userMapper.Adduser(user);
        if(!row.equals(1)){
            throw new InsertException("新增用户异常，请联系管理员");
        }
    }


    //用md5给密码加密
    public String getmd5password (String password,String salt){
         String msg = password + salt;
         for(int i=0; i<3; i++){
             msg = DigestUtils.md5DigestAsHex(msg.getBytes());
         }
        return msg;
    }


    public static  HttpSession getSession(){
        HttpSession session = null;
        try{
            session = getRequest().getSession();
        }catch (Exception e){}
            return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

}
