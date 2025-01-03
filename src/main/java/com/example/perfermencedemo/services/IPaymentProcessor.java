package com.example.perfermencedemo.services;

public interface IPaymentProcessor {
    boolean processPayment(String orderId);
}
