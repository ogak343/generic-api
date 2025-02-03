package com.example.genericrestapi.controller;

import com.example.genericrestapi.constants.ApiConstants;
import com.example.genericrestapi.dto.language.CreateLanguage;
import com.example.genericrestapi.dto.language.LanguageResponse;
import com.example.genericrestapi.dto.language.UpdateLanguage;
import com.example.genericrestapi.service.LanguageService;
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

@RestController
@RequestMapping(ApiConstants.LANGUAGE_URI)
public class LanguageController {

    private static final Logger log = LoggerFactory.getLogger(LanguageController.class);
    private final LanguageService service;

    public LanguageController(LanguageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LanguageResponse> create(@RequestBody @Valid CreateLanguage request) {
        log.info("Create language request: {}", request);
        return ResponseEntity.ok(service.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LanguageResponse> update(@PathVariable Long id, @RequestBody UpdateLanguage request) {
        log.info("Update language request: {}", request);
        return ResponseEntity.ok(service.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponse> get(@PathVariable Long id) {
        log.info("Get language id: {}", id);
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LanguageResponse>> getAll() {
        log.info("Get all languages");
        return ResponseEntity.ok(service.getAll());
    }
}
