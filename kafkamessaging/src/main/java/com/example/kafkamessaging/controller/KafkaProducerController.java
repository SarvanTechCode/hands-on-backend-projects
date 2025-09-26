package com.example.kafkamessaging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkamessaging.KafkaTopicConfig;
import com.example.kafkamessaging.Dto.MessageDto;

@RestController
public class KafkaProducerController {

    // make this optional - Spring will inject it only when kafka auto-config is active
    @Autowired(required = false)
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/publish")
    public String publish(@RequestBody MessageDto message) {
        String payload = message.toString();

        if (kafkaTemplate == null) {
            // Kafka is disabled (local profile). Just return success for local testing.
            System.out.println("Kafka disabled — received publish request: " + payload);
            return "Kafka disabled (local). Received: " + payload;
        }

        // production path: send to Kafka
        kafkaTemplate.send(KafkaTopicConfig.TOPIC, message.getId(), payload);
        System.out.println("Published to Kafka: " + payload);
        return "Published to Kafka: " + payload;
    }
}
