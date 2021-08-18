package com.shagihan.example.eventdrivensample.service;


import com.shagihan.example.eventdrivensample.model.Order;
import com.shagihan.example.eventdrivensample.model.OrderJMSMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {

    @Autowired
    private EmailService emailService;

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "${springrestjpa.rabbitmq.queue}")
    public void recievedMessage(OrderJMSMessage msg) {
        Order order = orderService.getOrder(msg.getOrderId());
        order.setState(Order.State.PROCESSING);
        orderService.updateOrder(order);
        emailService.SendEmail(msg);
    }

}
