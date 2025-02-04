package com.example.genericrestapi.dto.field;

import java.util.Map;

public record RequestFieldResponse(
        Long id,
        String name,
        Map<String, String> title,
        Long serviceId,
        String key,
        String pattern
) {
}
