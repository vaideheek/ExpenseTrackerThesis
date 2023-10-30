package com.example.expensetrackerthesis.services;


import com.example.expensetrackerthesis.entities.User;
import com.example.expensetrackerthesis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public User registerUser(String fullName, String email, String password) {
        // Check if the user with the given email already exists
        if (findUserByEmail(email) != null) {
            throw new RuntimeException("User with this email already exists.");
        }

        // Hash the password securely
        String hashedPassword = passwordEncoder.encode(password);

        // Create and save the user
        User user = new User();
        user.setName(fullName);
        user.setEmail(email);
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }
}
