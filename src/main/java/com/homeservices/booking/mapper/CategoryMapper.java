package com.homeservices.booking.mapper;

import com.homeservices.booking.dto.category.request.CategoryCreateRequest;
import com.homeservices.booking.dto.category.request.CategoryPatchRequest;
import com.homeservices.booking.dto.category.request.CategoryUpdateRequest;
import com.homeservices.booking.dto.category.response.CategoryResponse;
import com.homeservices.booking.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryCreateRequest request){
        if(request == null){
            return null;
        }

        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());

        return category;
    }

    public void updateEntity(Category category, CategoryUpdateRequest request){
        category.setName(request.getName());
        category.setDescription(request.getDescription());
    }

    public void patchEntity(Category category, CategoryPatchRequest request){
        if(request.getName() != null){
            category.setName(request.getName());
        }
        if (request.getDescription() != null) {
            category.setDescription(request.getDescription());
        }
    }

    public CategoryResponse toResponse(Category category){
        if(category == null){
            return null;
        }

        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());

        return response;
    }

}
