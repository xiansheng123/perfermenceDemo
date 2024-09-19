package com.example.perfermencedemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller1 {
    @GetMapping("demo")
    public String demo() throws InterruptedException {
        Thread.sleep(2000);
        return "demo successfully";
    }
}
