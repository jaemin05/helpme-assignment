package com.example.helpmeassignment.domain.admin.exception;

import com.example.helpmeassignment.domain.admin.exception.properties.AdminErrorCode;
import com.example.helpmeassignment.global.error.exception.CustomException;

public class AdminNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new AdminNotFoundException();

    private AdminNotFoundException() {
        super(AdminErrorCode.ADMIN_NOT_FOUND);
    }
}
