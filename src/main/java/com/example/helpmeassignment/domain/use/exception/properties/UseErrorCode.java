package com.example.helpmeassignment.domain.use.exception.properties;

import com.example.helpmeassignment.global.error.ErrorProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UseErrorCode implements ErrorProperty {

    IS_TOO_BIG_USE_AMOUNT(HttpStatus.BAD_REQUEST,"Is Too Big UseAmount");

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
