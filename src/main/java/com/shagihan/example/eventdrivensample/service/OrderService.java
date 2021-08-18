package com.shagihan.example.eventdrivensample.service;

import com.shagihan.example.eventdrivensample.model.Order;
import com.shagihan.example.eventdrivensample.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    public OrderService() {
        System.out.println("----OrderService----");
    }

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public Order createOrder(Order order) {
        order.setOrderDate(LocalDate.now());
        Order temp = orderRepository.save(order);
        return getOrder(temp.getId());
    }

    public Order getOrder(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public List<Order> getOrdersForCustomer(int userId) {
        return orderRepository.findByUser(userService.getUser(userId));
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    public void ProcessOrder(Order order) {
        order.setState(Order.State.PROCESSING);
    }
}
