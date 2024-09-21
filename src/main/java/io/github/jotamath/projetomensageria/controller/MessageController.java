package io.github.jotamath.projetomensageria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.jotamath.projetomensageria.producer.MessageProducer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.jotamath.projetomensageria.model.Message;


@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageProducer messageProducer;

    @PostMapping
    public String sendMessage(@RequestBody Message message) {
        messageProducer.sendMessage(message);
        return "Message sent to RabbitMQ: " + message.toString();
    }
    
}
