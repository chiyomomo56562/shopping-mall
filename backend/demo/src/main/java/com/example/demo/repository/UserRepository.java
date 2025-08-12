package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional 객체를 사용하면 값이 없는 상황에도 null을 반환하지 않고
    // Optional.empty()를 반환할 수 있습니다.
    Optional<User> findByUsername(String username);
}
