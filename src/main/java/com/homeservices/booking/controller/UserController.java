package com.homeservices.booking.controller;

import com.homeservices.booking.dto.user.request.UserCreateRequest;
import com.homeservices.booking.dto.user.response.UserResponse;
import com.homeservices.booking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserCreateRequest  request){
        UserResponse response = userService.create(request);
        URI location = URI.create("/api/v1/users/" + response.getId());
        /*
        // Points to the base path (e.g., http://localhost:8080/categories)
            URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath() // Base URL
                .path("/categories")     // Path to fetch all categories
                .build()
                .toUri();
         */
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserResponse> getById(@PathVariable ("user_id") Long userId){
        return ResponseEntity.ok().body(userService.getById(userId));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){
        List<UserResponse> responseList = userService.getAll();
         return ResponseEntity.ok().body(responseList);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<UserResponse>> createBulkRequest(@RequestBody List<UserCreateRequest> requests){
        List<UserResponse> responseList = userService.createBulkRequest(requests);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }

}
