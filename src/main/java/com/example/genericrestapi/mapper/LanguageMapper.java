package com.example.genericrestapi.mapper;

import com.example.genericrestapi.dto.language.CreateLanguage;
import com.example.genericrestapi.dto.language.LanguageResponse;
import com.example.genericrestapi.dto.language.UpdateLanguage;
import com.example.genericrestapi.entity.Language;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LanguageMapper {

    Language toEntity(CreateLanguage request);

    LanguageResponse toResponse(Language entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Language entity, UpdateLanguage request);
}
