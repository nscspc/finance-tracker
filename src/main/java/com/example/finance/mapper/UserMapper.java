package com.example.finance.mapper;

import com.example.finance.dto.CreateUserRequest;
import com.example.finance.entity.User;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(CreateUserRequest request) {

        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .active(true)
                .build();
    }
}