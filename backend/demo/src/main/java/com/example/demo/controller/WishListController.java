package com.example.demo.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.WishListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WishListController {
    // private final WishListService wishListService;
    
    // // 위시리스트 조회
    // @GetMapping("/wishList")
    // public String wishList(Principal principal) {
    //     return "wishList";
    // }

    // // 위시리스트 추가
    // @PostMapping("/wishList/add/{productId}")
    // public String addWishList(Principal principal, @PathVariable Long productId) {
    //     // wishListService.addWishList(productId);
    //     return "redirect:/product/" + productId;
    // }

    // // 위시리스트 삭제
    // @DeleteMapping("/wishList/delete/{productId}")
    // public String deleteWishList(Principal principal, @PathVariable Long productId) {
    //     // wishListService.deleteWishList(productId);
    //     return "redirect:/product/" + productId;
    // }
}
