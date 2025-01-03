package com.example.perfermencedemo.services;

import org.springframework.stereotype.Component;

@Component
public class RealIPaymentProcessor implements IPaymentProcessor {

    @Override
    public boolean processPayment(String orderId) {
        // 生产环境中的支付处理逻辑
        System.out.println("Processing payment for order: " + orderId);
        return true;  // 假设支付成功
    }
}
