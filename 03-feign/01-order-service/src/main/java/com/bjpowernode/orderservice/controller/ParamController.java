package com.bjpowernode.orderservice.controller;

import com.bjpowernode.orderservice.domain.Order;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamController {
    @GetMapping("/urlParam/{name}/{age}")
    public String urlParam(@PathVariable("name") String name,
                           @PathVariable("age") Integer age) {
        System.out.println("name: " + name +"  " + "age: " + age);
        return "urlParam ok";
    }

    @GetMapping("/headerParam")
    public String headerParam(@RequestParam String name,
                              @RequestParam Integer age) {
        System.out.println("name: " + name +"  " + "age: " + age);
        return "headerParam ok";
    }

    @PostMapping("/bodyParam")
    public String bodyParam(@RequestBody Order order) {
        System.out.println("order: "+order);
        return "bodyParam ok";
    }

    @PostMapping("/headerParamAndBodyParam")
    public String headerParamAndBodyParam(@RequestBody Order order,
                                          @RequestParam String name) {
        System.out.println("order: "+order);
        System.out.println("name: " + name);
        return "headerParamAndBodyParam ok";
    }

}
