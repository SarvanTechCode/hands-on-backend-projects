package com.example.kafkamessaging.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.kafkamessaging.KafkaTopicConfig;
import com.example.kafkamessaging.Dto.MessageDto;

public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody MessageDto message) {
        String payload = message.toString();
        kafkaTemplate.send(KafkaTopicConfig.TOPIC, message.getId(), payload);
        
        System.out.println("test");
        return "Published to Kafka: " + payload;
    }
}