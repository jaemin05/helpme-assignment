package com.example.helpmeassignment.domain.admin.exception;

import com.example.helpmeassignment.domain.admin.exception.properties.AdminErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class NameAlreadyExistsException extends CustomException {
    public static final CustomException EXCEPTION =
            new NameAlreadyExistsException();

    private NameAlreadyExistsException() {
        super(AdminErrorCode.NAME_ALREADY_EXISTS);
    }
}
