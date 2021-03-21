package com.example.kafkaboilerplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class KafkaConsumer {

    private final AtomicInteger receivedMessageCount = new AtomicInteger(0);

    @KafkaListener(topics = "${test.topic}")
    public void onMessage(String message) {
        log.info("Processed message={}", message);
        receivedMessageCount.incrementAndGet();
    }

    public int getReceivedMessageCount() {
        return receivedMessageCount.get();
    }
}
