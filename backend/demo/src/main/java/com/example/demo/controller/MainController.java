package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.WishListService;

import lombok.RequiredArgsConstructor;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    // private final ProductService productService;
    // private final ShoppingMallService shoppingMallService;
    // private final WishListService wishListService;

    @GetMapping("/")
    public String MainPage(Model model) {
        // 로그인 확인
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!"anonymousUser".equals(username)) {
            model.addAttribute("nickname", username);
        }
        // 메인 화면에 표시할 상품 목록 추가
        // 24시간 동안 조회수가 가장 많은 상품을 보여줘야한다.
        // List<Product> popularProducts = productService.getPopularProducts();
        // model.addAttribute("products", popularProducts);

        // 찜한 상품 목록 수 추가 (로그인 상태일 때만)
        // if (!"anonymousUser".equals(username)) {
        //     long wishListCount = wishListService.countWishListsByUsername(username);
        //     model.addAttribute("wishListCount", wishListCount);
        // }

        // 카테고리 목록 추가
        // model.addAttribute("categories", categoryService.findAll());

        return "mainPage";
    }
}
