package com.example.helpmeassignment.domain.admin.exception.properties;

import com.example.helpmeassignment.global.error.ErrorProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AdminErrorCode implements ErrorProperty {

    ADMIN_NOT_FOUND(HttpStatus.NOT_FOUND, "Admin Not Found"),

    NAME_ALREADY_EXISTS(HttpStatus.CONFLICT, "Name Already Exists"),
    ACCOUNT_ID_ALREADY_EXISTS(HttpStatus.CONFLICT, "Account Id Already Exists"),

    PASSWORD_MISS_MATCHED(HttpStatus.UNAUTHORIZED, "Password Miss Matched");

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
