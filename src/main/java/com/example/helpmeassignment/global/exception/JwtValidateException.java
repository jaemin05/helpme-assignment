package com.example.helpmeassignment.global.exception;

import com.example.helpmeassignment.global.error.GlobalErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class JwtValidateException extends CustomException {
    public static final CustomException EXCEPTION =
            new JwtValidateException();

    private JwtValidateException() {
        super(GlobalErrorCode.JWT_VALIDATE_FAILED);
    }
}
