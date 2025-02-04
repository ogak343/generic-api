package com.example.genericrestapi.controller;

import com.example.genericrestapi.constants.ApiConstants;
import com.example.genericrestapi.dto.language.CreateLanguage;
import com.example.genericrestapi.dto.language.LanguageResponse;
import com.example.genericrestapi.dto.language.UpdateLanguage;
import com.example.genericrestapi.manager.LanguageManager;
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

import static com.example.genericrestapi.constants.ApiConstants.LANGUAGE_CONTROLLER;
import static com.example.genericrestapi.constants.ApiConstants.LANGUAGE_URI;

@RestController
@RequestMapping(LANGUAGE_URI)
@Tag(name = LANGUAGE_CONTROLLER)
public class LanguageController {

    private static final Logger LOG = LoggerFactory.getLogger(LanguageController.class);
    private final LanguageManager facade;

    public LanguageController(LanguageManager facade) {
        this.facade = facade;
    }

    @PostMapping
    public ResponseEntity<LanguageResponse> create(@RequestBody @Valid CreateLanguage request) {
        LOG.info("Create language request: {}", request);
        return ResponseEntity.ok(facade.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LanguageResponse> update(@PathVariable Long id, @RequestBody @Valid UpdateLanguage request) {
        LOG.info("Update language request: {}", request);
        return ResponseEntity.ok(facade.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponse> get(@PathVariable Long id) {
        LOG.info("Get language id: {}", id);
        return ResponseEntity.ok(facade.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LanguageResponse>> getAll() {
        LOG.info("Get all languages");
        return ResponseEntity.ok(facade.getAll());
    }
}
