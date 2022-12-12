package com.example.helpmeassignment.domain.use.exception;

import com.example.helpmeassignment.domain.use.exception.properties.UseErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class IsTooBigUseAmountException extends CustomException {
    public static final CustomException EXCEPTION =
            new IsTooBigUseAmountException();

    private IsTooBigUseAmountException() {
        super(UseErrorCode.IS_TOO_BIG_USE_AMOUNT);
    }
}
