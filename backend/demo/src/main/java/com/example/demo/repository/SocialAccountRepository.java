package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SocialAccount;

public interface SocialAccountRepository extends JpaRepository<SocialAccount, Long> {
    SocialAccount findByProviderAndProviderId(String provider, String providerId);
}
