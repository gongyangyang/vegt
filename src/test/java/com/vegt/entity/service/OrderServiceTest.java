package com.vegt.entity.service;

import com.vegt.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void findsname(){
        Set<String > list = orderService.findCname();
        System.out.println(list);
    }
}
