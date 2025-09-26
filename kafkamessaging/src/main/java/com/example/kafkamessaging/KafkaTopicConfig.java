package com.example.kafkamessaging;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!local")   // <-- only create Kafka beans when NOT local
public class KafkaTopicConfig {
    public static final String TOPIC = "sarvan-topic";
    // topic creation beans etc. (if any)
}
