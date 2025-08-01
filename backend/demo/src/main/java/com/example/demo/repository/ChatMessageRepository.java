package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ChatMessages;

public interface ChatMessageRepository extends JpaRepository<ChatMessages, Long> {
    
}
