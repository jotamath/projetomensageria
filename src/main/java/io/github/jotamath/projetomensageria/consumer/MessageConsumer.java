package io.github.jotamath.projetomensageria.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.jotamath.projetomensageria.entity.Order;
import io.github.jotamath.projetomensageria.model.Message;
import io.github.jotamath.projetomensageria.repository.OrderRepository;

@Service
public class MessageConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @RabbitListener(queues="messageQueue")
    public void consumeMessage(String messageJson){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Message message = objectMapper.readValue(messageJson, Message.class);

            Order order = new Order();
            order.setCustomerId(message.getCustomerId());
            order.setProductId(message.getProductId());
            order.setPrice(message.getPrice());
            orderRepository.save(order);

        } catch (JsonProcessingException e) {
        }}
}
