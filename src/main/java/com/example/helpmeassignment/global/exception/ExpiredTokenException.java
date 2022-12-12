package com.example.helpmeassignment.global.exception;

import com.example.helpmeassignment.global.error.GlobalErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class ExpiredTokenException extends CustomException {
    public static final CustomException EXCEPTION =
            new ExpiredTokenException();

    private ExpiredTokenException() {
        super(GlobalErrorCode.JWT_EXPIRED);
    }
}
