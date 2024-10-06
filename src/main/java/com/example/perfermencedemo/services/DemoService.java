package com.example.perfermencedemo.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final SubService subService;

    public String getStr1() {
        return "call sub " + subService.getSubStr() + " successfully";

    }
}
