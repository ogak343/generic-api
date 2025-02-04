package com.example.genericrestapi.service;

import com.example.genericrestapi.constants.ErrorCode;
import com.example.genericrestapi.dto.category.CategoryResponse;
import com.example.genericrestapi.dto.category.CreateCategory;
import com.example.genericrestapi.dto.category.UpdateCategory;
import com.example.genericrestapi.entity.Category;
import com.example.genericrestapi.exception.CustomException;
import com.example.genericrestapi.mapper.CategoryMapper;
import com.example.genericrestapi.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;
    private final LanguageService languageService;

    public CategoryService(CategoryRepository repository,
                           CategoryMapper mapper,
                           LanguageService languageService
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.languageService = languageService;
    }

    public CategoryResponse create(CreateCategory request) {
        validateCategory(request.name(), request.title().keySet());
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public void validateExist(Long id) {
        if (!repository.existsById(id)) throw new CustomException(ErrorCode.CATEGORY_NOT_FOUND);
    }

    public CategoryResponse update(Long id, UpdateCategory request) {
        validateCategory(request.name(), request.title().keySet());

        var entity = getCategory(id);
        mapper.update(entity, request);
        return mapper.toResponse(repository.save(entity));
    }

    public CategoryResponse get(Long id) {
        return mapper.toResponse(getCategory(id));
    }

    public List<CategoryResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    private Category getCategory(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    private void validateCategory(String name, Set<String> keys) {
        if (name != null && repository.existsByName(name)) throw new CustomException(ErrorCode.CATEGORY_EXISTS);
        if (keys.isEmpty()) languageService.validateKeys(keys);
    }
}
