package com.bjpowernode.userservice.controller;

import com.bjpowernode.userservice.domain.Order;
import com.bjpowernode.userservice.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RestController
public class UserController {
    @Autowired
    private UserOrderFeign userOrderFeign;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String order() {
        return userOrderFeign.order();
    }

    @GetMapping("/urlParam")
    public String urlParam() {
        return userOrderFeign.urlParam("ljn", 25);
    }

    @GetMapping("/headerParam")
    public String headerParam() {
        return userOrderFeign.headerParam("ywl", 23);
    }

    @GetMapping("/bodyParam")
    public String bodyParam() {
        Order order = new Order();
        order.setId(1);
        order.setName("qian jiang ji za");
        order.setPrice(22D);
        return userOrderFeign.bodyParam(order);
    }

    @GetMapping("/headerParamAndBodyParam")
    public String headerParamAndBodyParam() {
        Order order = new Order();
        order.setId(1);
        order.setName("qian jiang ji za");
        order.setPrice(22D);
        String name = "abc";
        return userOrderFeign.headerParamAndBodyParam(order, name);
    }

    // 手写feign
    @GetMapping("/orderByCustomerFeign")
    public String orderByCustomerFeign() {
        UserOrderFeign userOrderFeign = (UserOrderFeign) Proxy.newProxyInstance(UserController.class.getClassLoader(),
                new Class[]{UserOrderFeign.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Class<?> declaringClass = method.getDeclaringClass();
                        FeignClient feignClient = declaringClass.getAnnotation(FeignClient.class);
                        String serviceName = feignClient.value();
                        GetMapping getMapping = method.getAnnotation(GetMapping.class);
                        String path = getMapping.value()[0];
                        String url = "http://"+serviceName+path;
                        String res = restTemplate.getForObject(url, String.class);
                        return res;
                    }
                });
        return userOrderFeign.order();
    }
}
