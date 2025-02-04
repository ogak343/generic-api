package com.example.genericrestapi.dto.service;

import java.util.Map;

public record UpdateService(
        String name,
        Map<String, String> title
) {
}
