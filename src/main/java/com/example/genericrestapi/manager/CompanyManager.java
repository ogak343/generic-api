package com.example.genericrestapi.manager;

import com.example.genericrestapi.constants.ErrorCode;
import com.example.genericrestapi.dto.company.CompanyResponse;
import com.example.genericrestapi.dto.company.CreateCompany;
import com.example.genericrestapi.dto.company.UpdateCompany;
import com.example.genericrestapi.entity.Company;
import com.example.genericrestapi.exception.CustomException;
import com.example.genericrestapi.mapper.CompanyMapper;
import com.example.genericrestapi.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CompanyManager {
    private final CompanyRepository repository;
    private final CompanyMapper mapper;
    private final LanguageManager languageManager;
    private final CategoryManager categoryManager;

    public CompanyManager(CompanyRepository repository,
                          CompanyMapper mapper,
                          LanguageManager languageManager,
                          CategoryManager categoryManager
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.languageManager = languageManager;
        this.categoryManager = categoryManager;
    }

    public CompanyResponse create(CreateCompany request) {
        validateCompany(request.name(), request.title().keySet());
        categoryManager.validateExist(request.categoryId());
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public CompanyResponse update(Long id, UpdateCompany request) {
        validateCompany(request.name(), request.title().keySet());

        var entity = getCompany(id);
        mapper.update(entity, request);
        return mapper.toResponse(repository.save(entity));
    }

    public CompanyResponse get(Long id) {
        return mapper.toResponse(getCompany(id));
    }

    public List<CompanyResponse> getByCategoryId(Long id) {
        return repository.findAllByCategoryId(id).stream().map(mapper::toResponse).toList();
    }

    private Company getCompany(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorCode.COMPANY_NOT_FOUND));
    }

    private void validateCompany(String name, Set<String> keys) {
        if (name != null && repository.existsByName(name)) throw new CustomException(ErrorCode.COMPANY_EXISTS);
        if (!keys.isEmpty()) languageManager.validateKeys(keys);
    }
}
