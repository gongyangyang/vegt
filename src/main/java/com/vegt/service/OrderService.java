package com.vegt.service;
import com.vegt.entity.order;

import java.util.Set;

public interface OrderService {
    Set<String> findCname();

    void addCorder(order order);

    order findOrder(String cid);

}
