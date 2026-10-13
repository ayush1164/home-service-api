package com.homeservices.booking.service.impl;

import com.homeservices.booking.dto.category.request.CategoryCreateRequest;
import com.homeservices.booking.dto.category.response.CategoryResponse;
import com.homeservices.booking.entity.Category;
import com.homeservices.booking.exception.ResourceNotFoundException;
import com.homeservices.booking.mapper.CategoryMapper;
import com.homeservices.booking.repository.CategoryRepository;
import com.homeservices.booking.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplement implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImplement(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponse create(CategoryCreateRequest request) {

        Category category = categoryMapper.toEntity(request);

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    public CategoryResponse getById(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        return categoryMapper.toResponse(category);
    }

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    public List<CategoryResponse> createBulkRequest(List<CategoryCreateRequest> requests) {

        List<Category> categoryList = requests
                .stream()
                .map(categoryMapper::toEntity)
                .toList();

        List<Category> savedCategories = categoryRepository.saveAll(categoryList);

        return savedCategories
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

}
