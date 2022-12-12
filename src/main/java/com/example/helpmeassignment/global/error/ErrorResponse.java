package com.example.helpmeassignment.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private final int status;
    private final String message;

    public static BindErrorResponse of(BindException e) {
        Map<String, String> errorMap = new HashMap<>();

        for (FieldError error : e.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        return new BindErrorResponse(GlobalErrorCode.BAD_REQUEST.status(), errorMap);
    }

    public static ErrorResponse of(MethodArgumentNotValidException e) {
        return new ErrorResponse(
                GlobalErrorCode.BAD_REQUEST.status(),
                e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
        );
    }

    @Getter
    @AllArgsConstructor
    public static class BindErrorResponse {
        private final int status;
        private final Map<String, String> errorMap;
    }
}
