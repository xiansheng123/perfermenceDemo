package com.example.perfermencedemo.services;


import com.example.perfermencedemo.kafka.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final SubService subService;
    private final KafkaSender kafkaSender;

    public String getStr1() {
        return "call sub " + subService.getSubStr() + " successfully";
    }
}
