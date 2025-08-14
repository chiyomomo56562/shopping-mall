package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.dto.SignupDto;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/usr/login")
    public String login() {
        return "usrLogin";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("signupDto", new SignupDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute SignupDto signupDto, Model model) {
        userService.saveUser(signupDto);
        return "redirect:/login";
    }

    // 비밀번호 재설정
    @PostMapping("/user/password/reset")
    public String resetPassword(@ModelAttribute SignupDto signupDto) {
        // userService.resetPassword(signupDto);
        return "redirect:/login";
    }

    // // 마이페이지
    // @GetMapping("/user/myPage")
    // public String myPage(Principal principal) {
    //     return "myPage";
    // }

    // @GetMapping("/user/myPage/edit")
    // public String editMyPage(Principal principal) {
    //     return "editMyPage";
    // }

    // @PatchMapping("/user/myPage/edit")
    // public String editMyPage(Principal principal, @ModelAttribute SignupDto signupDto) {
    //     // userService.updateUser(username, signupDto);
    //     return "redirect:/user/myPage";
    // }

    // @DeleteMapping("/user/myPage/delete")
    // public String deleteMyPage(Principal principal) {
    //     // userService.deleteUser(username);
    //     return "redirect:/";
    // }

    // // 거래 내역
    // @GetMapping("/user/transactionList")
    // public String transactionList(Principal principal) {
    //     return "transactionList";
    // }

    // //주소 관리
    // // 주소 목록
    // @GetMapping("/user/address")
    // public String addressList(Principal principal) {
    //     return "addressList";
    // }

    // // 주소 추가
    // @GetMapping("/user/address/add")
    // public String addAddress(Principal principal) {
    //     return "addAddress";
    // }

    // @PostMapping("/user/address/add")
    // public String addAddress(Principal principal, @ModelAttribute AddressDto addressDto) {
    //     // userService.addAddress(username, addressDto);
    //     return "redirect:/user/address";
    // }

    // // 주소 수정
    // @GetMapping("/user/address/edit/{addressId}")
    // public String editAddress(Principal principal, @PathVariable Long addressId) {
    //     return "editAddress";
    // }

    // @PatchMapping("/user/address/edit/{addressId}")
    // public String editAddress(Principal principal, @PathVariable Long addressId, @ModelAttribute AddressDto addressDto) {
    //     // userService.editAddress(username, addressId, addressDto);
    //     return "redirect:/user/address";
    // }

    // // 주소 삭제
    // @DeleteMapping("/user/address/delete/{addressId}")
    // public String deleteAddress(Principal principal, @PathVariable Long addressId) {
    //     // userService.deleteAddress(username, addressId);
    //     return "redirect:/user/address";
    // }
}
