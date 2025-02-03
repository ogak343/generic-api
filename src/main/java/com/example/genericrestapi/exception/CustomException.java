package com.example.genericrestapi.exception;

import com.example.genericrestapi.constants.ErrorCode;

public class CustomException extends RuntimeException {
    private final ErrorCode error;

    public CustomException(ErrorCode error) {
        this.error = error;
    }

    public ErrorCode getError() {
        return error;
    }
}
