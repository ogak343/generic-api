package com.example.genericrestapi.mapper;

import com.example.genericrestapi.dto.service.CreateService;
import com.example.genericrestapi.dto.service.ServiceResponse;
import com.example.genericrestapi.dto.service.UpdateService;
import com.example.genericrestapi.entity.Service;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {
    ServiceResponse toResponse(Service service);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Service entity, UpdateService request);

    Service toEntity(CreateService request);
}
