package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// import com.example.demo.service.ShoppingMallService;

@RestController
@RequestMapping("/")
public class ShoppingMallController {
    // private final ShoppingMallService shoppingMallService;
    @GetMapping("/")
    public String MainPage() {
        return "Main Page";
    }

    @GetMapping("/login")
    public String LoginPage() {
        return "Login Page";
    }

    @GetMapping("/signup")
    public String SignUpPage() {
        return "Sign Up Page";
    }
}
