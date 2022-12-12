package com.example.helpmeassignment.domain.member.exception.properties;

import com.example.helpmeassignment.global.error.ErrorProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MemberErrorCode implements ErrorProperty {

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "Member Not Found");

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
