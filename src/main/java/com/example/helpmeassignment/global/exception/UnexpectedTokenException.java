package com.example.helpmeassignment.global.exception;

import com.example.helpmeassignment.global.error.GlobalErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class UnexpectedTokenException extends CustomException {
    public static final CustomException EXCEPTION =
            new UnexpectedTokenException();

    private UnexpectedTokenException() {
        super(GlobalErrorCode.UNEXPECTED_TOKEN);
    }
}
