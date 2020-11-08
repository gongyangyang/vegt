package com.vegt.service.serviceImpl;
import com.vegt.entity.order;
import com.vegt.mapper.OrderMapper;
import com.vegt.service.OrderService;
import com.vegt.service.exception.InsertException;
import com.vegt.service.exception.OrderFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Override
    public order findOrder(String cid) {
        order order = new order();
        if(cid==null || cid.equals("")){
            throw new OrderFindException("对不起您输入的订单号为空，请输入正确的订单号");
        }else{
           order= orderMapper.Findorder(cid);
           if(order==null){
               throw new OrderFindException("对不起您输入的订单号不存在，请输入正确的订单号");
           }
            System.out.println("[订单]:"+order);
        }
        return order;
    }

}
