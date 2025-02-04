package com.example.genericrestapi.dto.service;

import java.util.Map;

public record ServiceResponse(
        Long id,
        String name,
        Map<String, String> title,
        Long companyId
) {
}
