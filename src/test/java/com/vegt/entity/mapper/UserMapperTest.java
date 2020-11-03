package com.vegt.entity.mapper;

import com.vegt.entity.user;
import com.vegt.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper mapper;

    @Test
    public void Adduser() {
        user u = new user();
        u.setUsername("谭林");
        u.setPassword("123");
        u.setSalt("123321");
        u.setPhone("1008611");
        Integer result = mapper.Adduser(u);
        System.out.println(result);
    }

    @Test
    public void getuser() {
        user u = new user();
        String name = "潘远科";
        u = mapper.getuser(name);
        System.out.println(u);
    }

}
