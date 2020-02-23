package com.microservice.producer.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitMQIn {
    String INPUT = "input";

    @Input(RabbitMQIn.INPUT)
    SubscribableChannel input();
}
