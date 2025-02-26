package com.brimstone.rabbitmq.producer.config;

import lombok.Setter;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
public class RabbitConfig {

  @Value("${queue.name}")
  private String queueName;

  @Bean
  public Queue queue() {
    return new Queue(queueName, Boolean.FALSE);
  }
}
