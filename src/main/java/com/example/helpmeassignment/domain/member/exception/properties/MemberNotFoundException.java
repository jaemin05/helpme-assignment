package com.example.helpmeassignment.domain.member.exception.properties;

import com.example.helpmeassignment.global.error.exception.CustomException;

public class MemberNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new MemberNotFoundException();

    private MemberNotFoundException() {
        super(MemberErrorCode.MEMBER_NOT_FOUND);
    }
}
