package com.example.perfermencedemo.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testProcessOrder() {
        String result = orderService.processOrder("Order-12345");
        assertEquals("Payment Failed", result);  // 验证使用了 MockPaymentProcessor 的行为
    }
}
