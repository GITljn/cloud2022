package com.bjpowernode.customerservice.controller;

import com.bjpowernode.customerservice.feign.CustomerRentCarFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRentCarFeign customerRentCarFeign;

    @GetMapping("/toRent")
    public String toRent() {
        return customerRentCarFeign.rent();
    }
}
