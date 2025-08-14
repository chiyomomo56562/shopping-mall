package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
// import com.example.demo.service.ReviewService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    // private final ReviewService reviewService;

    // // 유저 리뷰 조회
    // @GetMapping("/{userId}")
    // public String reviewList(@PathVariable Long userId, @RequestParam Long Page, Model model) {
    //     return "reviewList";
    // }

    // // 유저 리뷰 추가
    // @GetMapping("/add/{userId}")
    // public String addReviewForm(@PathVariable Long userId) {
    //     return "addReview";
    // }

    // @PostMapping("/add/{userId}")
    // public String addReview(@PathVariable Long userId, @ModelAttribute ReviewDto reviewDto) {
    //     return "redirect:/review/{userId}";
    // }

    // // 유저 리뷰 수정
    // @GetMapping("/{reviewId}")
    // public String editReviewForm(@PathVariable Long reviewId) {
    //     return "editReview";
    // }

    // @PatchMapping("/{reviewId}")
    // public String editReview(@PathVariable Long reviewId) {
    //     return "editReview";
    // }

    // // 유저 리뷰 삭제
    // @DeleteMapping("/{reviewId}")
    // public String deleteReview(@PathVariable Long reviewId) {
    //     return "redirect:/reviews/{userId}";
    // }
}
