package com.brimstone.rabbitmq.receiver.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitReceiver {

  @RabbitListener(queues = {"FirstQueue"})
  public void receiver(String message) {
    log.info("{} - received from queue", message);
  }
}
