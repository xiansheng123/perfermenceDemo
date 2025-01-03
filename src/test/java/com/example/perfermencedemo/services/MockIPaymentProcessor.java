package com.example.perfermencedemo.services;


import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
//@TestComponent
public class MockIPaymentProcessor implements IPaymentProcessor {

    @Override
    public boolean processPayment(String orderId) {
        System.out.println("Mock processing payment for order: " + orderId);
        return false;  // 模拟支付失败
    }
}
