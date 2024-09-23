package com.example.perfermencedemo;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
public class Controller1 {
    private final DemoService demoService;

    @GetMapping("demo")
    public String demo() throws InterruptedException {
        Thread.sleep(2000);
        log.info("current thread {} {}", Thread.currentThread().getId(), Thread.currentThread().getName());
        return demoService.getStr1();
    }
}
