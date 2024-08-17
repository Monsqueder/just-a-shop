package com.mlachowski;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PurchaseConsumer {

    @KafkaListener(topics = "${kafka-topic}", groupId = "${spring.kafka.producer.group-id}")
    public void processPurchaseEvent(PurchaseMessage message) {
        System.out.println(message);
    }

}
