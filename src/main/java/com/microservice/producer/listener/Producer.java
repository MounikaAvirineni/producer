package com.microservice.producer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.producer.binder.RabbitMQOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
public class Producer {

 @Autowired
 Source rabbitMQOut;

 @PostMapping(value = "/sendMessage")
 public String sendMessage(@RequestBody String payload) {

 /* ObjectMapper ob = new ObjectMapper();
     String msg = null;
     try {
         msg = ob.readValue(payload,String.class);
     } catch (JsonProcessingException e) {
         System.out.println("JSON formatting issue");
         return "JSON formatting issue";
     }*/

     rabbitMQOut.output().send(MessageBuilder.
             withPayload("hello RabbitMq consumer!")
             .setHeader("myHeader","myHeaderValue")
             .build());
     System.out.println("Sent Message!");
     return  "SUCCESS";


 }

}
