package com.example.helpmeassignment.domain.admin.service;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import com.example.helpmeassignment.domain.admin.exception.PasswordMissMatchedException;
import com.example.helpmeassignment.domain.admin.facade.AdminFacade;
import com.example.helpmeassignment.domain.admin.presentation.dto.request.LoginAdminRequest;
import com.example.helpmeassignment.domain.auth.presentation.dto.response.TokenResponse;
import com.example.helpmeassignment.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final AdminFacade adminFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public TokenResponse execute(LoginAdminRequest request) {
        Admin admin = adminFacade.getUserByAccountId(request.getAccountId());

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw PasswordMissMatchedException.EXCEPTION;
        }

        TokenResponse token = jwtTokenProvider.getToken(request.getAccountId());

        return new TokenResponse(token.getAccessToken(), token.getRefreshToken());
    }
}
