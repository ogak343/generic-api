package com.example.genericrestapi.dto.category;

import java.util.Map;

public record CategoryResponse(
        Long id,
        String name,
        Map<String, String> title
) {
}
