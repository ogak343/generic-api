package com.example.genericrestapi.dto.language;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateLanguage(
        @NotNull @Pattern(regexp = "^[a-z]{2}$") String code,
        @NotEmpty String description
) {
}
