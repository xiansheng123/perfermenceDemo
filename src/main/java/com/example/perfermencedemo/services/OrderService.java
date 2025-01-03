package com.example.perfermencedemo.services;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final IPaymentProcessor IPaymentProcessor;

    public OrderService(IPaymentProcessor IPaymentProcessor) {
        this.IPaymentProcessor = IPaymentProcessor;
    }

    public String processOrder(String orderId) {
        return IPaymentProcessor.processPayment(orderId) ? "Order Processed" : "Payment Failed";
    }
}
