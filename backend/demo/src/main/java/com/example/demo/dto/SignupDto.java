package com.example.demo.dto;

import com.example.demo.entity.User;

import com.example.demo.embeddable.Email;
import com.example.demo.embeddable.Phone;
import com.example.demo.enums.Role;

import lombok.Data;

@Data
public class SignupDto {
    private String username;
    private String password;
    private String passwordConfirm;
    private String nickname;
    private String phoneNumber;
    private String email;

    public User toEntity(String encodedPassword) {
        return User.builder()
                .username(username)
                .password(encodedPassword)
                .nickname(nickname)
                .phoneNumber(new Phone(phoneNumber))
                .email(new Email(email))
                .role(Role.USER)
                .build();
    }
}
