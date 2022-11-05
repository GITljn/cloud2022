package com.bjpowernode.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public String doLogin() {
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token, token);
        return token;
    }

    @GetMapping("/message")
    public String getMessage() {
        return "获取私信成功";
    }
}
