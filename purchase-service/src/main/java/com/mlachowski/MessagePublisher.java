package com.mlachowski;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    @Value("${kafka-topic}")
    private String topic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MessagePublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(PurchaseMessage purchaseMessage) {
        kafkaTemplate.send(topic, purchaseMessage);
    }

}
