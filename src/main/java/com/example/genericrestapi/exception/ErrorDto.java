package com.example.genericrestapi.exception;

public record ErrorDto(
        int code,
        String message
) {
}
