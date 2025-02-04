package com.example.genericrestapi.dto.language;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateLanguage(
        @NotNull @Pattern(regexp = "^[a-z]{2}$") String code,
        @NotBlank String description
) {
}
