package com.example.kafkamessaging;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    public static final String TOPIC = "sarvan-topic";

    @Bean
    public NewTopic createTopic() {
        // topicName, numPartitions, replicationFactor
        return new NewTopic(TOPIC, 1, (short) 1);
    }
}