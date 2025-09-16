package com.tapan.service;

import com.tapan.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class KafkaListener {
    private static final Logger log = LoggerFactory.getLogger(KafkaListener.class);

    @Autowired
    private UserRepo repo;
    @org.springframework.kafka.annotation.KafkaListener(topics = "order-events")
    public void consume(String message)
    {
        log.info("Received event from Order Service: "+message);

        if (message.startsWith("ORDER_CREATED")) {
            log.info("Notification: A new order was created. Details "+message);
        } else if (message.startsWith("ORDER_DELETED")) {
            log.info("Notification: An order was deleted. Details "+ message);
        } else {
            log.warn("Unknown event type received: "+message);
        }    }
}
