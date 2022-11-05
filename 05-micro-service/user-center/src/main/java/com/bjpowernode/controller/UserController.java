package com.bjpowernode.controller;

import com.bjpowernode.domain.Order;
import com.bjpowernode.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserOrderFeign userOrderFeign;

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable("id") Integer id) {
        return userOrderFeign.getOrderById(id);
    }
}
