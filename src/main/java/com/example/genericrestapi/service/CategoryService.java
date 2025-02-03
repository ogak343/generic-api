package com.example.genericrestapi.service;

import com.example.genericrestapi.constants.ErrorCode;
import com.example.genericrestapi.dto.category.CategoryResponse;
import com.example.genericrestapi.dto.category.CreateCategory;
import com.example.genericrestapi.dto.category.UpdateCategory;
import com.example.genericrestapi.exception.CustomException;
import com.example.genericrestapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryResponse create(CreateCategory category) {

        validateCategory(category);

        return null;
    }

    private void validateCategory(CreateCategory category) {
        if (repository.existsByName(category.name())) throw new CustomException(ErrorCode.CATEGORY_EXISTS);


    }

    public CategoryResponse update(Long id, UpdateCategory category) {
        return null;
    }

    public CategoryResponse get(Long id) {
        return null;
    }

    public List<CategoryResponse> getAll() {
        return null;
    }
}
