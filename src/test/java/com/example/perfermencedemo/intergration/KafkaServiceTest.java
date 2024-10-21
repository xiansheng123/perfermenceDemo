package com.example.perfermencedemo.intergration;

import com.example.perfermencedemo.kafka.KafkaConsumer;
import com.example.perfermencedemo.kafka.KafkaSender;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class KafkaServiceTest {

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private KafkaSender producer;

    @Value("${test.topic}")
    private String topic;

    @Test
    public void givenEmbeddedKafkaBroker_whenSendingWithSimpleProducer_thenMessageReceived()
            throws Exception {
        String data = "Sending with our own simple KafkaProducer";

        producer.sendMessage(topic, data);
        producer.sendMessage(topic, data+"1");
        producer.sendMessage(topic, data+"2");
        producer.sendMessage(topic, data+"3");

        boolean messageConsumed = consumer.latch.await(10, TimeUnit.SECONDS);
        assertTrue(messageConsumed);

    }
}
