package com.bjpowernode.nacosclienta.controller;

import com.bjpowernode.nacosclienta.feign.ABFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlphaController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ABFeign abFeign;

    @GetMapping("/test")
    public String test() {
        List<ServiceInstance> instances = discoveryClient.getInstances("client-b-nacos");
        System.out.println(instances.size());
        return abFeign.info();
    }
}
