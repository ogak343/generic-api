package com.example.genericrestapi.dto.company;

import java.util.Map;

public record CompanyResponse(
        Long id,
        String name,
        Map<String, String> title,
        Long categoryId
) {
}
