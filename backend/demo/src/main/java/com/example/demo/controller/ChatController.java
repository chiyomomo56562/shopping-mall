package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    // private final ChatService chatService;
    
    // // 채팅방 조회
    // @GetMapping("/{userId}")
    // public String chatRoomList(@PathVariable Long userId) {
    //     return "chatRoomList";
    // }

    // // 채팅방 추가
    // @PostMapping("/")
    // public String addChatRoom(@RequestParam Long currentUserId, @RequestParam Long targetUserId) {
    //     return "redirect:/chat/{userId}";
    // }

    // // 채팅방 나가기
    // @DeleteMapping("/{chatRoomId}")
    // public String deleteChatRoom(@PathVariable Long chatRoomId, @RequestParam Long userId) {
    //     return "redirect:/chat/{userId}";
    // }

    // // 채팅방 조회
    // @GetMapping("/{chatRoomId}")
    // public String chatRoom(@PathVariable Long chatRoomId) {
    //     return "chatRoom";
    // }
}
