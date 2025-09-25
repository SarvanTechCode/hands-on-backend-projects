package com.example.kafkamessaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = KafkaTopicConfig.TOPIC, groupId = "sarvan-group")
	public void listen(String message) {
		
		System.out.println("=== Received from Kafka ===");
        System.out.println(message);
        System.out.println("===========================");
		
	}
	
}
