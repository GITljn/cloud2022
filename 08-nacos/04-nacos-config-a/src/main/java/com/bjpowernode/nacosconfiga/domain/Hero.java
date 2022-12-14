package com.bjpowernode.nacosconfiga.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {
    @Value("${hero.name}")
    private String name;
    @Value("${hero.age}")
    private Integer age;
    @Value("${hero.addr}")
    private String addr;
}
