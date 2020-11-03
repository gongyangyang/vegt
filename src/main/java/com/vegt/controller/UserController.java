package com.vegt.controller;
import com.vegt.entity.user;
import com.vegt.service.UserService;
import com.vegt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.ibatis.annotations.Param;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@ResponseBody
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired(required = false)
    public UserService userService;


    //用户登录
    @RequestMapping("login")
    public JsonResult<user> GetUser
            (@Param("username") String username, @Param("password") String password,
             @Param("request") HttpServletRequest request,@Param("response")HttpServletResponse response) {
        user user = userService.Sel(username,password);
        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8020");//处理跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//表示是否允许发送Cookie
        response.setHeader("Set-Cookie", "HttpOnly;Secure;SameSite=None");
        String uname = user.getUsername();
        HttpSession session = request.getSession();
        //System.out.println(uname);
        session.setAttribute("uname",uname);
        //System.out.println("sessionName:"+ session.getAttribute("uname"));
        return new JsonResult<user>(SUCCESS);
    }





    //用户注册
    @RequestMapping("reg")
    @CrossOrigin(origins = "http://localhost:8080")
    public JsonResult<Void> Register( user user){
       userService.InserUser(user);
        return new JsonResult<>(SUCCESS);
    }
}
