package com.microservice.producer.binder;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitMQOut {
    String OUTPUT = "input";

    @Input(RabbitMQOut.OUTPUT)
    SubscribableChannel input();
}
