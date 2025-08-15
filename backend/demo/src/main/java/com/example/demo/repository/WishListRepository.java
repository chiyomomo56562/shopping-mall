package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.WishList;
import java.util.List;

public interface WishListRepository extends JpaRepository<WishList, Long> {

    // 위시 리스트를 조회할 때, 
    // product, user의 정보를 포함해서 조회하지 않으면 n+1문제가 발생한다.
    @Query("SELECT w FROM WishList w JOIN FETCH w.product p JOIN FETCH p.user u WHERE u.id = :userId")
    List<WishList> findAllWithProductAndUser(@Param("userId") Long userId);
    
    // 특정 사용자의 위시리스트 목록을 조회
    List<WishList> findByUser_Id(Long userId);

    // 특정 사용자의 위시리스트 개수를 조회
    long countByUser_Id(Long userId);

    // 특정 사용자의 위시리스트에 특정 상품이 존재하는지 확인
    boolean existsByUser_IdAndProductId(Long userId, Long productId);

    // 특정 사용자의 위시리스트에 특정 상품을 삭제
    void deleteByUser_IdAndProductId(Long userId, Long productId);
}
