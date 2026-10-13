package com.homeservices.booking.service.impl;

import com.homeservices.booking.dto.user.request.UserCreateRequest;
import com.homeservices.booking.dto.user.response.UserResponse;
import com.homeservices.booking.entity.User;
import com.homeservices.booking.exception.ResourceNotFoundException;
import com.homeservices.booking.mapper.UserMapper;
import com.homeservices.booking.repository.UserRepository;
import com.homeservices.booking.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImplement(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse create(UserCreateRequest request) {
        User user = userMapper.toEntity(request);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResponse getById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public List<UserResponse> createBulkRequest(List<UserCreateRequest> requests) {
        // 1. Validate list is not empty (Optional guard rail)
        if (requests == null || requests.isEmpty()) {
            return null;
        }

        List<User> users = requests.stream()
                .map(userMapper::toEntity)
                .toList();

        List<User> savedUsers = userRepository.saveAll(users);

        return savedUsers.stream()
                .map(userMapper::toResponse)
                .toList();
    }
}
