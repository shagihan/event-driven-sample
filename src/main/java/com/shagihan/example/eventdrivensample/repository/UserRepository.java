package com.shagihan.example.eventdrivensample.repository;

import com.shagihan.example.eventdrivensample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
