package com.shagihan.example.eventdrivensample.service;

import com.shagihan.example.eventdrivensample.model.OrderJMSMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private UserService userService;

    public EmailService() {
        System.out.println("---- Email service.create-----");
    }

    public void SendEmail(OrderJMSMessage orderJMSMessage) {
        System.out.println("-------Sending email -------");
        System.out.println("Order ID : " + orderJMSMessage.getOrderId());
        System.out.println("User ID : " + orderJMSMessage.getUserId());
        System.out.println("Sending email to : " + userService.getUser(orderJMSMessage.getUserId()).getEmail());
        System.out.println("-------email sent -------");
    }
}
