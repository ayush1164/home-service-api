package com.homeservices.booking.mapper;

import com.homeservices.booking.dto.user.request.UserCreateRequest;
import com.homeservices.booking.dto.user.response.UserResponse;
import com.homeservices.booking.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UserMapper {

    public User toEntity(@RequestBody UserCreateRequest request){
        if(request == null){
            return null;
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setRole(request.getRole());

        return user;
    }

    public UserResponse toResponse(User user){
        if (user == null) {
            return null;
        }

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setPhone(user.getPhone());
        response.setAddress(user.getAddress());
        response.setRole(user.getRole());

        return response;
    }

}
