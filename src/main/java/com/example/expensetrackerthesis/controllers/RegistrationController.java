package com.example.expensetrackerthesis.controllers;

import com.example.expensetrackerthesis.entities.User;
import com.example.expensetrackerthesis.repositories.UserRepository;
import com.example.expensetrackerthesis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final UserService userService; // Add this field

    @Autowired
    public RegistrationController(UserRepository userRepository, UserService userService) { // Add UserService as a constructor parameter
        this.userRepository = userRepository;
        this.userService = userService; // Initialize UserService
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
            modelAndView.setViewName("register");
            modelAndView.addObject("error", "Passwords do not match. Please try again.");
            return modelAndView;
        }

        User existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            modelAndView.setViewName("register");
            modelAndView.addObject("error", "Email already in use.");
            return modelAndView;
        }

        User newUser = userService.registerUser(name, email, password);
        userRepository.save(newUser);

        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
