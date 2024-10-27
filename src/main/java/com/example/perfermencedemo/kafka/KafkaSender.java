package com.example.perfermencedemo.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.adapter.BatchToRecordAdapter;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage1(String topic, Object message) throws ExecutionException, InterruptedException {
        log.info("sender topic1:{}", topic);
        log.info("sender message1:{}", message);
        var aa = kafkaTemplate.send(topic, message);
        log.info("kafka sender result1: {} | {}", aa.get().getRecordMetadata().offset(), aa.get().getRecordMetadata().partition());
    }

    public void sendMessage2(String topic, String message) {
        ProducerRecord<String, String> config = new ProducerRecord<>(topic, message);
        val send = kafkaTemplate.send(topic, message);
        send.whenComplete((result,ex)->{
            if (ex == null) {
                log.info("send sucessfull!");
                log.info("offset {}",result.getRecordMetadata().offset());
                log.info("partition {}",result.getRecordMetadata().partition());
            }
            else {
               log.error("send error:",ex);
            }
        });

    }

}
