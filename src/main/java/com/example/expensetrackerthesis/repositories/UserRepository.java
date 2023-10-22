package com.example.expensetrackerthesis.repositories;

import com.example.expensetrackerthesis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    // Additional query methods can be added here if needed
}
