package com.microservice.producer.listener;

import com.microservice.producer.binder.RabbitMQIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@EnableBinding(Sink.class)
public class Consumer {

    @Autowired
    Sink rabbitMQIn;

    @StreamListener(Sink.INPUT)
    public void processMessage(@Payload String message)
    {
        System.out.println(message);
    }
}
