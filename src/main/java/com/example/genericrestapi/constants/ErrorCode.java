package com.example.genericrestapi.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    CATEGORY_EXISTS(HttpStatus.CONFLICT, "Category already exists"),
    LANGUAGE_EXISTS(HttpStatus.CONFLICT, "Language already exists"),
    INVALID_LANGUAGE_SPECIFIED(HttpStatus.BAD_REQUEST, "Invalid language specified"),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "Category not found"),
    COMPANY_NOT_FOUND(HttpStatus.NOT_FOUND, "Company not found"),
    COMPANY_EXISTS(HttpStatus.CONFLICT, "Company already exists"),
    SERVICE_NOT_FOUND(HttpStatus.NOT_FOUND, "Service not found"),
    FIELD_NOT_FOUND(HttpStatus.NOT_FOUND, "Field not found"),
    FIELD_EXISTS(HttpStatus.CONFLICT, "Field already exists"),
    LANGUAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "Language not found");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
