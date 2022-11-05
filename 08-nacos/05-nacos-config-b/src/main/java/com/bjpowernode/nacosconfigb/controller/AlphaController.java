package com.bjpowernode.nacosconfigb.controller;

import com.bjpowernode.nacosconfigb.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlphaController {
    @Autowired
    private Hero hero;

    @GetMapping("/info")
    public String info() {
        return hero.getName()+":"+hero.getAge()+":"+hero.getAddr()+":"+hero.getHobby();
    }
}
