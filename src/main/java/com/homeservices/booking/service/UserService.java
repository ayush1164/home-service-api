package com.homeservices.booking.service;

import com.homeservices.booking.dto.user.request.UserCreateRequest;
import com.homeservices.booking.dto.user.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserCreateRequest request);

    UserResponse getById(Long userId);

    List<UserResponse> getAll();

    List<UserResponse> createBulkRequest(List<UserCreateRequest> requests);
}
