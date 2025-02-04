package com.example.genericrestapi.dto.language;

import jakarta.validation.constraints.Pattern;

public record UpdateLanguage(
        @Pattern(regexp = "^[a-z]{2}$") String code,
        String description
) {
}
