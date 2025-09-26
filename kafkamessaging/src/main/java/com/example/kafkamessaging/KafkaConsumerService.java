package com.example.kafkamessaging;

import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Profile("!local")   // <-- only active when profile is NOT "local"
public class KafkaConsumerService {

    @KafkaListener(topics = KafkaTopicConfig.TOPIC, groupId = "sarvan-group")
    public void listen(String message) {
        System.out.println("Consumed: " + message);
        // your processing...
    }
}
