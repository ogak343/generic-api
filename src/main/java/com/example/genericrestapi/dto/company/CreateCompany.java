package com.example.genericrestapi.dto.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record CreateCompany(
        @NotBlank String name,
        @NotNull @NotEmpty Map<String, String> title,
        @NotNull Long categoryId
) {
}
