package com.bjpowernode.customerservice.feign;

import com.bjpowernode.customerservice.hystrix.CustomerRentCarFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "rent-car-service", fallback = CustomerRentCarFeignHystrix.class)
public interface CustomerRentCarFeign {
    @GetMapping("/rent")
    String rent();
}
