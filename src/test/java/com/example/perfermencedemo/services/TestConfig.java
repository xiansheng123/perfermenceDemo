package com.example.perfermencedemo.services;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    // 通过扫描加载 @TestComponent，也可以通过 @Bean 显式声明
     @Bean
     public IPaymentProcessor paymentProcessor() {
         return new MockIPaymentProcessor();
     }
}
