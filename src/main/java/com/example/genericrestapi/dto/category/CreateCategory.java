package com.example.genericrestapi.dto.category;

import java.util.Map;

public record CreateCategory(
        String name,
        Map<String, String> title
) {
}
