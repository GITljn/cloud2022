package com.bjpowernode.customerservice.hystrix;

import com.bjpowernode.customerservice.feign.CustomerRentCarFeign;
import org.springframework.stereotype.Component;

@Component
public class CustomerRentCarFeignHystrix implements CustomerRentCarFeign {
    @Override
    public String rent() {
        return "进入熔断器";
    }
}
