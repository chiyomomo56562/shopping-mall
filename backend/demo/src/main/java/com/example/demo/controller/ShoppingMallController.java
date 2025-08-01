package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

// import com.example.demo.service.ShoppingMallService;

@RestController
@RequestMapping("/api")
public class ShoppingMallController {
    // private final ShoppingMallService shoppingMallService;
    @GetMapping("/")
    public String MainPage() {
        return "Main Page";
    }
}
