package com.bjpowernode.feign;

import com.bjpowernode.domain.Order;
import com.bjpowernode.hystrix.UserOrderFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "order-center", fallback = UserOrderFeignHystrix.class)
public interface UserOrderFeign {
    @GetMapping("/order/getOrderById")
    Order getOrderById(@RequestParam Integer id);
}
