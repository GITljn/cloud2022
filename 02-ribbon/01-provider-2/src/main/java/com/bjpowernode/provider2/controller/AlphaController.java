package com.bjpowernode.provider2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlphaController {

    @GetMapping("/alpha")
    public String alpha() {
        return "实例2";
    }
}
