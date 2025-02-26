package com.brimstone.rabbitmq.producer.controller;

import com.brimstone.rabbitmq.producer.service.MessageSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private final MessageSender messageSender;

  public MainController(MessageSender messageSender) {
    this.messageSender = messageSender;
  }

  @PostMapping("/send")
  public ResponseEntity<?> send(@RequestBody String text) {
    if (text.isBlank()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    messageSender.send(text);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
