package com.bjpowernode.userservice.feign;

import com.bjpowernode.userservice.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("order-service")
public interface UserOrderFeign {
    @GetMapping("/order")
    String order();

    @GetMapping("/urlParam/{name}/{age}")
    String urlParam(@PathVariable("name") String name,
                    @PathVariable("age") Integer age);

    @GetMapping("/headerParam")
    String headerParam(@RequestParam String name,
                       @RequestParam Integer age);

    @PostMapping("/bodyParam")
    String bodyParam(@RequestBody Order order);

    @PostMapping("/headerParamAndBodyParam")
    String headerParamAndBodyParam(@RequestBody Order order,
                                   @RequestParam String name);
}
