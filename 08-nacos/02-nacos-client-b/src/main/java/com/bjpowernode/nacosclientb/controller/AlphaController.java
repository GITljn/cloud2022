package com.bjpowernode.nacosclientb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlphaController {
    @GetMapping("/info")
    public String info() {
        String a = "a";
        return "远程调用成功";
    }
}
