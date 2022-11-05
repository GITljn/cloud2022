package com.bjpowernode.controller;

import com.bjpowernode.domain.Order;
import com.bjpowernode.feign.UserOrderFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/order")
public class OrderController implements UserOrderFeign {

    // 对应的路径也会复用接口中的路径，因此不能在类上加路径
    @Override
    public Order getOrderById(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setName("订单名称");
        order.setPrice(180D);

        return order;
    }
}
