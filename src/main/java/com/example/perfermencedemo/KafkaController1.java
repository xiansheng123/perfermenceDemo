package com.example.perfermencedemo;


import com.example.perfermencedemo.kafka.KafkaSender;
import com.example.perfermencedemo.services.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;


@RestController
@Slf4j
@RequiredArgsConstructor
public class KafkaController1 {
    private final DemoService demoService;
    private final KafkaSender kafkaSender;

    @GetMapping("demo")
    public String demo() throws InterruptedException {
        Thread.sleep(2000);
        log.info("current thread {} {}", Thread.currentThread().threadId(), Thread.currentThread().getName());
        return demoService.getStr1();
    }

    @PostMapping("/send")
    public String sendMessageToKafka(@RequestParam String topic, @RequestBody Object message) throws ExecutionException, InterruptedException {
        kafkaSender.sendMessage1(topic, message);
        return "Message sent to Kafka topic: " + topic;
    }
}
