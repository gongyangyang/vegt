package com.vegt.service.serviceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.vegt.entity.order;
import com.vegt.mapper.OrderMapper;
import com.vegt.service.OrderService;
import com.vegt.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


@Service
public class OrederServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Set<String> findCname() {
        System.out.println("aaa");
        Set<String> selcname = orderMapper.Selcname();
        System.out.println("cName"+selcname);
        return selcname;
    }

    @Override
    public void addCorder(order order) {
        order or = new order();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String cdate = sf.format(date);
        or.setCid(order.getCid());
        or.setCname(order.getCname());
        or.setCtime(cdate);
        or.setCtype(order.getCtype());
        or.setComments(order.getComments());
        System.out.println("1111:"+order.getCtype());
        Integer i =  orderMapper.inCorder(or);
        if(i<1){
            throw new InsertException("插入数据异常，请联系管理员");
        }
    }

}
