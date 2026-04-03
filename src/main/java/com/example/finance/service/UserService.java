package com.example.finance.service;

import com.example.finance.dto.CreateUserRequest;
import com.example.finance.entity.User;
import com.example.finance.mapper.UserMapper;
import com.example.finance.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserRequest request) {

        User user = UserMapper.toEntity(request);

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}