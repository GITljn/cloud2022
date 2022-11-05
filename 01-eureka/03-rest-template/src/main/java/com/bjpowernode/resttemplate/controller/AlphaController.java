package com.bjpowernode.resttemplate.controller;

import com.bjpowernode.resttemplate.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlphaController {

    @GetMapping("/testGet")
    public String get(String name) {
        System.out.println(name);
        return "ok";
    }

    // JSON类型的参数
    @PostMapping("/testPost1")
    public String post1(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }

    // 表单类型的参数
    @PostMapping("/testPost2")
    public String post2(User user) {
        System.out.println(user);
        return "ok";
    }
}
