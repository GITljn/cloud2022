package com.bjpowernode.customhystrix.controller;

import com.bjpowernode.customhystrix.annotation.CustomHystrixAnno;
import com.bjpowernode.customhystrix.model.CustomHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AlphaController {
    @Autowired
    private RestTemplate restTemplate;

    @CustomHystrixAnno
    @GetMapping("/toRpc")
    public String toRpc() {
        String url = "http://abc:8080/toRpc";
        return restTemplate.getForObject(url, String.class);
    }
}
