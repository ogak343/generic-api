package com.example.genericrestapi.mapper;

import com.example.genericrestapi.dto.language.CreateLanguage;
import com.example.genericrestapi.dto.language.LanguageResponse;
import com.example.genericrestapi.dto.language.UpdateLanguage;
import com.example.genericrestapi.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface LanguageMapper {

    Language toEntity(CreateLanguage request);

    LanguageResponse toResponse(Language entity);

    void update(@MappingTarget Language entity, UpdateLanguage request);
}
