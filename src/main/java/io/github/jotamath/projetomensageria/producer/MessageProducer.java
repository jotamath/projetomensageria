package io.github.jotamath.projetomensageria.producer;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Message message) {
        try {
            String messageJson = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend("messageQueue", messageJson);
        } catch (JsonProcessingException | AmqpException e) {
        }
    }

    public void sendMessage(io.github.jotamath.projetomensageria.model.Message message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
