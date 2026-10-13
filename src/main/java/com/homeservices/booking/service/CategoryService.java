package com.homeservices.booking.service;

import com.homeservices.booking.dto.category.request.CategoryCreateRequest;
import com.homeservices.booking.dto.category.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryCreateRequest request);

    CategoryResponse getById(Long categoryId);

    List<CategoryResponse> getAll();

    List<CategoryResponse> createBulkRequest(List<CategoryCreateRequest> requests);
}
