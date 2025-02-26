package com.brimstone.rabbitmq.producer.service;

import lombok.Setter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Setter
@Service
public class MessageSender {

  @Value("${queue.name}")
  private String queueName;

  private final AmqpTemplate amqpTemplate;

  public MessageSender(AmqpTemplate amqpTemplate) {
    this.amqpTemplate = amqpTemplate;
  }

  public void send(String message) {
    amqpTemplate.convertAndSend(queueName, message);
  }
}
