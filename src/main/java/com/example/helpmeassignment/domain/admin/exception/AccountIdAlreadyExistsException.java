package com.example.helpmeassignment.domain.admin.exception;

import com.example.helpmeassignment.domain.admin.exception.properties.AdminErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class AccountIdAlreadyExistsException extends CustomException {
    public static final CustomException EXCEPTION =
            new AccountIdAlreadyExistsException();

    private AccountIdAlreadyExistsException() {
        super(AdminErrorCode.ACCOUNT_ID_ALREADY_EXISTS);
    }
}
