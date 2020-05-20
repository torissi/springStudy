package com.example.demo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControll {

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }
}
