package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import jakarta.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = true)
    private Product product;

    // 주소
    @Column(nullable = false)
    private String roadNameAddress;
    
    @Column(nullable = false)
    private String detailAddress;
    
    // 우편 번호
    @Column(nullable = false)
    private String zipCode;
    
    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private boolean isDefault;
    
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
