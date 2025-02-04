package com.example.genericrestapi.dto.field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record CreateRequestField(
        @NotBlank String name,
        @NotNull Map<String, String> title,
        @NotNull Long serviceId,
        @NotBlank String key,
        @NotBlank String pattern
) {
}
