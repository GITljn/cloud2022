package com.bjpowernode.rentcarservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RentCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentCarApplication.class, args);
    }

}
