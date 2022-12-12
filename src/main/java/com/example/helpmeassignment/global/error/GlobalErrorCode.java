package com.example.helpmeassignment.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GlobalErrorCode implements ErrorProperty {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad Request"),

    JWT_VALIDATE_FAILED(HttpStatus.UNAUTHORIZED, "Token Validate Failed"),
    JWT_EXPIRED(HttpStatus.UNAUTHORIZED, "Jwt Token Expired"),
    JWT_SIGNATURE(HttpStatus.UNAUTHORIZED, "Invalid Signature"),
    UNEXPECTED_TOKEN(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Token Exception"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
    private final HttpStatus status;
    private final String message;

    @Override
    public int status() {
        return status.value();
    }

    @Override
    public String message() {
        return message;
    }
}
