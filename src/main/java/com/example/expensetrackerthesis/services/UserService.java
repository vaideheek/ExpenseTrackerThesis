package com.example.expensetrackerthesis.services;

import com.example.expensetrackerthesis.entities.User;
import com.example.expensetrackerthesis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
