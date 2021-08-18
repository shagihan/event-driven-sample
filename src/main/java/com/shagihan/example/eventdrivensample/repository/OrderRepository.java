package com.shagihan.example.eventdrivensample.repository;

import com.shagihan.example.eventdrivensample.model.Order;
import com.shagihan.example.eventdrivensample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser(User user);
}