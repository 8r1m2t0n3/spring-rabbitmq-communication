package com.brimstone.rabbitmq.producer;

import com.brimstone.rabbitmq.producer.service.MessageSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class  RabbitmqProducerApplication {
  public static void main(String[] args) {
    ApplicationContext applicationContext = SpringApplication.run(RabbitmqProducerApplication.class, args);

    MessageSender messageSender = (MessageSender) applicationContext.getBean("messageSender");


    for(int i = 0;;i++) {
      messageSender.send("New message " + i);
    }
  }
}
