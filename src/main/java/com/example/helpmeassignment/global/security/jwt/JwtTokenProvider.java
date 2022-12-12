package com.example.helpmeassignment.global.security.jwt;

import com.example.helpmeassignment.domain.auth.domain.RefreshToken;
import com.example.helpmeassignment.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.helpmeassignment.domain.auth.presentation.dto.response.TokenResponse;
import com.example.helpmeassignment.global.security.jwt.properties.JwtProperties;
import com.example.helpmeassignment.global.security.principle.AuthDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    private static final String ACCESS_KEY = "access";
    private static final String REFRESH_KEY = "refresh";

    public TokenResponse getToken(String accountId) {
        String accessToken = generateToken(accountId, ACCESS_KEY, jwtProperties.getAccessExp());
        String refreshToken = generateRefreshToken(accountId);

        return new TokenResponse(accessToken, refreshToken);
    }

    public String generateRefreshToken(String accountId) {
        String newRefreshToken = generateToken(accountId, REFRESH_KEY, jwtProperties.getRefreshExp());
        refreshTokenRepository.save(
                RefreshToken.builder()
                        .accountId(accountId)
                        .refreshToken(newRefreshToken)
                        .ttl(jwtProperties.getRefreshExp())
                        .build());
        return newRefreshToken;
    }

    private String generateToken(String accountId, String type, Long expiration) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setSubject(accountId)
                .setHeaderParam("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }
}
