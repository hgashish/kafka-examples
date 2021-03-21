package com.example.kafkaboilerplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, topics = "test-users", brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class KafkaIntegrationTest {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConsumer consumer;

    @Test
    void testSendReceiveMessage() throws Exception {
        Assertions.assertEquals(0, consumer.getReceivedMessageCount());
        String message = "This is sample message.";
        kafkaProducer.sendMessage(message);
        Thread.sleep(5000);
        Assertions.assertEquals(1, consumer.getReceivedMessageCount());
    }
}
