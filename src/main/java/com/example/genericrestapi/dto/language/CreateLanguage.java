package com.example.genericrestapi.dto.language;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateLanguage(
        @NotNull @Pattern(regexp = "") String code,
        @NotEmpty String description
) {
}
