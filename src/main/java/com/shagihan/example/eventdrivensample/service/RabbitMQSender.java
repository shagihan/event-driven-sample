package com.shagihan.example.eventdrivensample.service;

import com.shagihan.example.eventdrivensample.model.OrderJMSMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Service
public class RabbitMQSender {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQSender.class);
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${springrestjpa.rabbitmq.exchange}")
    private String exchange;

    @Value("${springrestjpa.rabbitmq.routingkey}")
    private String routingkey;

    public void send(OrderJMSMessage order) {
        rabbitTemplate.convertAndSend(exchange, routingkey, order);

        log.debug("Send msg = " + order);
    }
}
