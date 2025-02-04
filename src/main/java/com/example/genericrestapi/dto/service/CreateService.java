package com.example.genericrestapi.dto.service;

import java.util.Map;

public record CreateService(
        String name,
        Map<String, String> title,
        Long companyId
) {
}
