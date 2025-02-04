package com.example.genericrestapi.manager;

import com.example.genericrestapi.constants.ErrorCode;
import com.example.genericrestapi.dto.service.CreateService;
import com.example.genericrestapi.dto.service.ServiceResponse;
import com.example.genericrestapi.dto.service.UpdateService;
import com.example.genericrestapi.exception.CustomException;
import com.example.genericrestapi.mapper.ServiceMapper;
import com.example.genericrestapi.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceManager {

    private final ServiceRepository repository;
    private final ServiceMapper mapper;

    public ServiceManager(ServiceRepository repository,
                          ServiceMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ServiceResponse create(CreateService request) {
        return mapper.toResponse(repository.save(mapper.toEntity(request)));
    }

    public ServiceResponse update(Long id, UpdateService request) {
        var entity = getService(id);
        mapper.update(entity, request);
        return mapper.toResponse(repository.save(entity));
    }

    public ServiceResponse get(Long id) {
        return mapper.toResponse(getService(id));
    }

    public List<ServiceResponse> getByCompanyId(Long id) {
        return repository.findAllByCompanyId(id).stream().map(mapper::toResponse).toList();
    }

    private com.example.genericrestapi.entity.Service getService(Long id) {
        return repository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.SERVICE_NOT_FOUND));
    }

    public void validateExist(Long serviceId) {
        if (!repository.existsById(serviceId)) throw new CustomException(ErrorCode.SERVICE_NOT_FOUND);
    }
}
