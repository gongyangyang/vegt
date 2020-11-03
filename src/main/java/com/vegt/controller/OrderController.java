package com.vegt.controller;

import com.vegt.entity.order;
import com.vegt.entity.user;
import com.vegt.service.OrderService;
import com.vegt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

@RestController
@ResponseBody
@RequestMapping("order")
public class OrderController extends BaseController {

    @Autowired(required = false)
    public OrderService orderService;

    @RequestMapping("cuser")
    public JsonResult<Set<String>>  findCname (){
        Set<String> list =orderService.findCname();
        return new JsonResult<Set<String>>(SUCCESS,list);
    }

    @RequestMapping("inorder")
    public JsonResult<Void> inCorder (order order){
        orderService.addCorder(order);
        return new JsonResult<Void>(SUCCESS);
    }
}
