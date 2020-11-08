package com.vegt.entity.mapper;
import com.vegt.entity.order;
import com.vegt.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


@SpringBootTest
public class OrderMapperTest {

    @Autowired
    OrderMapper orderMapper;

    @Test
    public void Selcname(){
      Set<String> list= orderMapper.Selcname();
        System.out.println(list);
    }

    @Test
    public void coder(){
        String cid = "202010291655";
        String cname = "测试用户";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String vtime = sf.format(new Date());
        String ctype = "日常买菜";
        String comments = "小谭买的菜";
        order order = new order();
        order.setCid(cid);
        order.setCname(cname);
        order.setCtime(vtime);
        order.setCtype(ctype);
        order.setComments(comments);
        Integer i =  orderMapper.inCorder(order);
        System.out.println(i);
    }

    @Test
   public void findorder (){
        String cid ="20201107211137130";
        order od = orderMapper.Findorder(cid);
       System.out.println(od);
   }
}
