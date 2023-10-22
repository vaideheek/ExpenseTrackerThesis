package com.example.expensetrackerthesis.controllers;

import com.example.expensetrackerthesis.entities.User;
import com.example.expensetrackerthesis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword
    ) {
        ModelAndView modelAndView = new ModelAndView();

        if (!password.equals(confirmPassword)) {
            // Passwords do not match, show an error message
            modelAndView.setViewName("register");
            modelAndView.addObject("error", "Passwords do not match. Please try again.");
            return modelAndView;
        }

        // Check if the email is already registered
        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            // Email already in use, show an error message
            modelAndView.setViewName("register");
            modelAndView.addObject("error", "Email already in use.");
            return modelAndView;
        }

        // Create a new user and save it to the database
        User newUser = new User(name, email, password);
        userRepository.save(newUser);



        // Redirect to the login page after successful registration
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
