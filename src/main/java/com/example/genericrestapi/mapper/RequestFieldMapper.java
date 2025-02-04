package com.example.genericrestapi.mapper;

import com.example.genericrestapi.dto.field.CreateRequestField;
import com.example.genericrestapi.dto.field.RequestFieldResponse;
import com.example.genericrestapi.dto.field.UpdateRequestField;
import com.example.genericrestapi.entity.RequestField;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RequestFieldMapper {
    RequestFieldResponse toResponse(RequestField requestField);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget RequestField entity, UpdateRequestField request);

    RequestField toEntity(CreateRequestField request);
}
