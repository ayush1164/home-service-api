package com.homeservices.booking.controller;

import com.homeservices.booking.dto.category.request.CategoryCreateRequest;
import com.homeservices.booking.dto.category.response.CategoryResponse;
import com.homeservices.booking.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryCreateRequest request){
        CategoryResponse response = categoryService.create(request);
        URI location = URI.create("/api/v1/categories/" + response.getId());
        return  ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable ("category_id") Long categoryId){
        return ResponseEntity.ok().body(categoryService.getById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        List<CategoryResponse> responseList = categoryService.getAll();
        return ResponseEntity.ok().body(responseList);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<CategoryResponse>> createBulkRequest(@RequestBody List<CategoryCreateRequest> requests){
        List<CategoryResponse> responseList = categoryService.createBulkRequest(requests);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseList);
    }

}
