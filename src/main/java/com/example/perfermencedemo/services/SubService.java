package com.example.perfermencedemo.services;


import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SubService {
    public String getDateStr() {
        return LocalDateTime.now().toString();
    }
}
