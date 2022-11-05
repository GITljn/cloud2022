package com.bjpowernode.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AlphaController {

    @Autowired
    private RestTemplate restTemplate;

    // restTemplate可以实现负载均衡的原因
    // 1. ribbon拦截请求，从url中得到服务名称
    // 2. 根据服务名称，从Eureka中得到服务的实例列表
    // 3. 根据负载均衡算法，选取一个服务，并得到ip和port
    // 4. 重构url，发起请求
    @GetMapping("/alpha")
    public String alpha(String serviceName) {
        String url = "http://" + serviceName + "/alpha";
        return restTemplate.getForObject(url, String.class);
    }
}
