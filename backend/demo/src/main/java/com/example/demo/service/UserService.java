package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import com.example.demo.repository.UserRepository;
import com.example.demo.dto.SignupDto;
import com.example.demo.entity.User;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public void saveUser(SignupDto signupDto) {
        if(!signupDto.getPassword().equals(signupDto.getPasswordConfirm())) {
            throw new IllegalArgumentException("Password and PasswordConfirm do not match");
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(signupDto.getPassword());
        
        //Dto를 엔티티로 변환 후 저장
        User user = signupDto.toEntity(encodedPassword);
        userRepository.save(user);
    }
}
