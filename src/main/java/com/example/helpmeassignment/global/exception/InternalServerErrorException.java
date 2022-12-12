package com.example.helpmeassignment.global.exception;

import com.example.helpmeassignment.global.error.GlobalErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class InternalServerErrorException extends CustomException {

    public static final CustomException EXCEPTION =
            new InternalServerErrorException();

    private InternalServerErrorException() {
        super(GlobalErrorCode.INTERNAL_SERVER_ERROR);
    }
}
