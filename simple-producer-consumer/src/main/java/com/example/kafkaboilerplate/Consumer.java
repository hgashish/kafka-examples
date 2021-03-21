package com.example.kafkaboilerplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @KafkaListener(topics = "${test.topic}")
    public void onMessage(String message) {
        log.info("Processed message={}", message);
    }
}
