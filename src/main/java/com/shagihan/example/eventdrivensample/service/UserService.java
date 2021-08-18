package com.shagihan.example.eventdrivensample.service;

import com.shagihan.example.eventdrivensample.model.User;
import com.shagihan.example.eventdrivensample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User SaveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> SaveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUserList(int limit, int offset) {
        return userRepository.findAll(PageRequest.of(offset, limit)).getContent();
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
