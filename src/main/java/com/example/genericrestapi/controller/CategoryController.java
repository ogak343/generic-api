package com.example.genericrestapi.controller;

import com.example.genericrestapi.dto.category.CategoryResponse;
import com.example.genericrestapi.dto.category.CreateCategory;
import com.example.genericrestapi.dto.category.UpdateCategory;
import com.example.genericrestapi.manager.CategoryManager;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static com.example.genericrestapi.constants.ApiConstants.CATEGORY_CONTROLLER;
import static com.example.genericrestapi.constants.ApiConstants.CATEGORY_URI;

@RestController
@RequestMapping(CATEGORY_URI)
@Tag(name = CATEGORY_CONTROLLER)
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryManager categoryManager;

    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody @Valid CreateCategory category) {

        LOG.info("Create category: {}", category);
        return ResponseEntity.ok(categoryManager.create(category));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody UpdateCategory category) {

        LOG.info("Update category: {}", category);
        return ResponseEntity.ok(categoryManager.update(id, category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> get(@PathVariable Long id) {

        LOG.info("Get category: {}", id);
        return ResponseEntity.ok(categoryManager.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> getAll() {

        LOG.info("Get all categories");
        return ResponseEntity.ok(categoryManager.getAll());
    }
}
