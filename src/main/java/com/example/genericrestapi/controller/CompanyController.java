package com.example.genericrestapi.controller;

import com.example.genericrestapi.dto.company.CompanyResponse;
import com.example.genericrestapi.dto.company.CreateCompany;
import com.example.genericrestapi.dto.company.UpdateCompany;
import com.example.genericrestapi.manager.CompanyManager;
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

import static com.example.genericrestapi.constants.ApiConstants.COMPANIES_CONTROLLER;
import static com.example.genericrestapi.constants.ApiConstants.COMPANIES_URI;

@RestController
@RequestMapping(COMPANIES_URI)
@Tag(name = COMPANIES_CONTROLLER)
public class CompanyController {

    private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);
    private final CompanyManager service;

    public CompanyController(CompanyManager service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> create(@RequestBody @Valid CreateCompany request) {

        LOG.info("Create company :{}", request);
        return ResponseEntity.ok(service.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CompanyResponse> update(@PathVariable Long id, @RequestBody UpdateCompany request) {

        LOG.info("Update company id: {}, request: {}", id, request);
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponse> get(@PathVariable Long id) {

        LOG.info("Get company id: {}", id);
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<CompanyResponse>> getByCategory(@PathVariable Long id) {

        LOG.info("Get companies by categoryId: {}", id);
        return ResponseEntity.ok(service.getByCategoryId(id));
    }
}
