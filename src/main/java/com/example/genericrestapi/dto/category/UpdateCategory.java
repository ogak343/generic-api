package com.example.genericrestapi.dto.category;

import java.util.Map;

public record UpdateCategory(
        String name,
        Map<String, String> title
) {
}
