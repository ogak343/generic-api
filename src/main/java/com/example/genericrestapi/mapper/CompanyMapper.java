package com.example.genericrestapi.mapper;

import com.example.genericrestapi.dto.company.CompanyResponse;
import com.example.genericrestapi.dto.company.CreateCompany;
import com.example.genericrestapi.dto.company.UpdateCompany;
import com.example.genericrestapi.entity.Company;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    CompanyResponse toResponse(Company company);

    Company toEntity(CreateCompany request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Company entity, UpdateCompany request);
}
