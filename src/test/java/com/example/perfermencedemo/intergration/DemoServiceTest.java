package com.example.perfermencedemo.intergration;

import com.example.perfermencedemo.kafka.KafkaSender;
import com.example.perfermencedemo.services.DemoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoServiceTest {

    @Autowired
    DemoService demoService;

    @Test
    void test1() {
        System.out.println(demoService.getStr1());
    }

}
