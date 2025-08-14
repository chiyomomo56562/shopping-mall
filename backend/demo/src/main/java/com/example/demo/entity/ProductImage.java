package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// @Entity
// @Table(name = "product_images")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// @EntityListeners(AuditingEntityListener.class)
// public class ProductImage {
//     @Id
//     @GeneratedValue
//     private long id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name="product", nullable=false)
//     private Product product;

//     private String imageUrl;

//     @CreatedDate
//     @Column(nullable = false)
//     private LocalDateTime createdAt;

//     @LastModifiedDate
//     @Column(nullable = false)
//     private LocalDateTime updatedAt;
// }
