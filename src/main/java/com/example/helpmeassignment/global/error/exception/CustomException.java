package com.example.helpmeassignment.global.error.exception;

import com.example.helpmeassignment.global.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class CustomException extends RuntimeException {
    private final ErrorProperty errorProperty;

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
