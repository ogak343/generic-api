package com.example.genericrestapi.mapper;

import com.example.genericrestapi.dto.category.CategoryResponse;
import com.example.genericrestapi.dto.category.CreateCategory;
import com.example.genericrestapi.dto.category.UpdateCategory;
import com.example.genericrestapi.entity.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    CategoryResponse toResponse(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Category entity, UpdateCategory request);

    Category toEntity(CreateCategory request);
}
