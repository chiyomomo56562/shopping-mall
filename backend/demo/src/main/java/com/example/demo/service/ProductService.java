package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getPopularProducts() {
        //조회수 순으로 5개 가져온다. 원래는 시간단위로 계산해야겠지만..
        return productRepository.findTop5ByOrderByViewsCountDesc();
    }    
}
