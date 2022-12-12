package com.example.helpmeassignment.global.exception;

import com.example.helpmeassignment.global.error.GlobalErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class SignatureTokenException extends CustomException {
    public static final CustomException EXCEPTION =
            new SignatureTokenException();

    private SignatureTokenException() {
        super(GlobalErrorCode.JWT_SIGNATURE);
    }
}
