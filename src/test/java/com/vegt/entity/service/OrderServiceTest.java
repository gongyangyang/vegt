package com.vegt.entity.service;

import com.vegt.entity.order;
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

    @Test
    public void findorder(){
        order order = new order();
       order= orderService.findOrder("20201107213859659");
        System.out.println(order);
    }
}
