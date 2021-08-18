package com.shagihan.example.eventdrivensample.controller;

import com.shagihan.example.eventdrivensample.model.Order;
import com.shagihan.example.eventdrivensample.model.OrderJMSMessage;
import com.shagihan.example.eventdrivensample.service.OrderService;
import com.shagihan.example.eventdrivensample.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        rabbitMQSender.send(new OrderJMSMessage(order.getId(), order.getUser().getId(), order.getEta().toString()));
        return ResponseEntity.accepted().body(createdOrder);
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable("userId") int userId) {
        return ResponseEntity.ok(orderService.getOrdersForCustomer(userId));
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") int orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}
