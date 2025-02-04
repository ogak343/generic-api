package com.example.genericrestapi.dto.company;

import java.util.Map;

public record UpdateCompany(
        String name,
        Map<String, String> title
) {
}
