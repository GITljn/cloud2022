package com.bjpowernode.nacosclienta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("client-b-nacos")
public interface ABFeign {
    @GetMapping("/info")
    String info();
}
