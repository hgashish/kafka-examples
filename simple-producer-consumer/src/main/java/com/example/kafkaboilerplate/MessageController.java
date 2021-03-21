package com.example.kafkaboilerplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/kafka")
public class MessageController {

    private Producer producer;

    @Autowired
    public MessageController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("publish")
    public void sendMessage(@RequestBody String message) {
        producer.sendMessage(message);
    }
}
