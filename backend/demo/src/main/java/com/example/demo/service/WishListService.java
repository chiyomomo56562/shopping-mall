package com.example.demo.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.demo.repository.WishListRepository;
import com.example.demo.entity.WishList;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final WishListRepository wishListRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public long countWishListsByUsername(String username) {
        // 특정 사용자의 위시리스트 개수를 조회
        return wishListRepository.countByUser_Username(username);
    }

    public boolean existsByUsernameAndProductId(String username, Long productId) {
        // 특정 사용자의 위시리스트에 특정 상품이 존재하는지 확인
        return wishListRepository.existsByUser_UsernameAndProductId(username, productId);
    }

    public void deleteByUsernameAndProductId(String username, Long productId) {
        // 특정 사용자의 위시리스트에 특정 상품을 삭제
        wishListRepository.deleteByUsernameAndProductId(username, productId);
    }

    public void addWishList(String username, Long productId) {
        // 특정 사용자의 위시리스트에 특정 상품을 추가

        // 이미 위시리스트에 추가된 상품이면 예외 발생
        if (wishListRepository.existsByUser_UsernameAndProductId(username, productId)) { throw new IllegalStateException("Product already in wishlist"); }

        // 위시리스트에 추가
        WishList wishList = new WishList();
        wishList.setUser(userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found")));
        wishList.setProduct(productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found")));
        wishListRepository.save(wishList);
    }
}
