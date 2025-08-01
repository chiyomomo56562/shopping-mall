package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.demo.entity.ChatRoom;
import com.example.demo.entity.User;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
 
    List<ChatRoom> findBySeller(User user);
    List<ChatRoom> findByBuyer(User user);
    List<ChatRoom> findBySellerOrBuyer(User seller, User buyer);
}
