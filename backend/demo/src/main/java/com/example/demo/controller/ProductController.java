package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    
    // // 상품 조회
    // @GetMapping("/{productId}")
    // public String productDetail(@PathVariable Long productId) {
    //     return "productDetail";
    // }

    // // 상품 추가
    // @GetMapping("/add")
    // public String addProductForm() {
    //     return "addProduct";
    // }

    // @PostMapping("/add")
    // public String addProduct(@ModelAttribute ProductDto productDto) {
    //     return "redirect:/products";
    // }

    // // 상품 수정
    // @GetMapping("/{productId}/edit")
    // public String editProductForm(@PathVariable Long productId) {
    //     return "editProduct";
    // }

    // @PatchMapping("/{productId}/edit")
    // public String editProduct(@PathVariable Long productId) {
    //     return "editProduct";
    // }

    // // 상품 삭제
    // @DeleteMapping("/{productId}")
    // public String deleteProduct(@PathVariable Long productId) {
    //     return "redirect:/products";
    // }
}
