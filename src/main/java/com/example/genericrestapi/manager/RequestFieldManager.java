package com.example.genericrestapi.manager;

import com.example.genericrestapi.constants.ErrorCode;
import com.example.genericrestapi.dto.field.CreateRequestField;
import com.example.genericrestapi.dto.field.RequestFieldResponse;
import com.example.genericrestapi.dto.field.UpdateRequestField;
import com.example.genericrestapi.entity.RequestField;
import com.example.genericrestapi.exception.CustomException;
import com.example.genericrestapi.mapper.RequestFieldMapper;
import com.example.genericrestapi.repository.RequestFieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RequestFieldManager {
    private final RequestFieldRepository repository;
    private final RequestFieldMapper mapper;
    private final LanguageManager languageManager;
    private final ServiceManager serviceManager;

    public RequestFieldManager(RequestFieldRepository repository,
                               RequestFieldMapper mapper,
                               LanguageManager languageManager,
                               ServiceManager serviceManager
    ) {
        this.repository = repository;
        this.mapper = mapper;
        this.languageManager = languageManager;
        this.serviceManager = serviceManager;
    }

    public RequestFieldResponse create(CreateRequestField request) {
        validateField(request.key(), request.serviceId(), request.title().keySet());

        serviceManager.validateExist(request.serviceId());
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public RequestFieldResponse update(Long id, UpdateRequestField request) {
        var entity = getField(id);
        mapper.update(entity, request);
        return mapper.toResponse(repository.save(entity));
    }

    public RequestFieldResponse get(Long id) {
        return mapper.toResponse(getField(id));
    }

    public List<RequestFieldResponse> getByServiceId(Long id) {
        return repository.findAllByServiceId(id).stream().map(mapper::toResponse).toList();
    }

    private RequestField getField(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.FIELD_NOT_FOUND));
    }

    private void validateField(String key, Long serviceId, Set<String> keys) {
        if (repository.existsByKeyAndServiceId(key, serviceId))
            throw new CustomException(ErrorCode.FIELD_EXISTS);
        languageManager.validateKeys(keys);
    }
}
