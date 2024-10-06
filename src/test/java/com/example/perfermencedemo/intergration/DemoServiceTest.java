package com.example.perfermencedemo.intergration;

import com.example.perfermencedemo.services.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoServiceTest {

    @Autowired
    DemoService demoService;

    @Test
    void test1() {
        System.out.println(demoService.getStr1());
    }


}
