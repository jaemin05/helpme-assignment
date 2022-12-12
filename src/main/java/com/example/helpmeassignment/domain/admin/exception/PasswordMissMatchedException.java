package com.example.helpmeassignment.domain.admin.exception;

import com.example.helpmeassignment.domain.admin.exception.properties.AdminErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class PasswordMissMatchedException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordMissMatchedException();

    private PasswordMissMatchedException() {
        super(AdminErrorCode.PASSWORD_MISS_MATCHED);
    }
}
