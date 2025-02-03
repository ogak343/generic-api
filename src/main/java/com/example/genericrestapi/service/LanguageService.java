package com.example.genericrestapi.service;

import com.example.genericrestapi.constants.ErrorCode;
import com.example.genericrestapi.dto.language.CreateLanguage;
import com.example.genericrestapi.dto.language.LanguageResponse;
import com.example.genericrestapi.dto.language.UpdateLanguage;
import com.example.genericrestapi.entity.Language;
import com.example.genericrestapi.exception.CustomException;
import com.example.genericrestapi.mapper.LanguageMapper;
import com.example.genericrestapi.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    public LanguageService(LanguageRepository repository, LanguageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public LanguageResponse create(CreateLanguage request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public List<LanguageResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    public LanguageResponse get(Long id) {
        return mapper.toResponse(getLanguage(id));
    }

    private Language getLanguage(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.LANGUAGE_NOT_FOUND));
    }

    public LanguageResponse update(Long id, UpdateLanguage request) {
        var entity = getLanguage(id);
        mapper.update(entity, request);
        return mapper.toResponse(repository.save(entity));
    }
}
