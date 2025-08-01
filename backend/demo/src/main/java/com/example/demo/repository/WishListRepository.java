package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    
}
