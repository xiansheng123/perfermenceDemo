package com.example.perfermencedemo.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, Object message) throws ExecutionException, InterruptedException {
        log.info("sender topic:{}", topic);
        log.info("sender message:{}", message);
        var aa = kafkaTemplate.send(topic, message);
        log.info("result: {} | {}", aa.get().getRecordMetadata().offset(), aa.get().getRecordMetadata().partition());
    }

}
