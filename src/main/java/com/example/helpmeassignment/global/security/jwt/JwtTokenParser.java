package com.example.helpmeassignment.global.security.jwt;

import com.example.helpmeassignment.global.exception.ExpiredTokenException;
import com.example.helpmeassignment.global.exception.JwtValidateException;
import com.example.helpmeassignment.global.exception.SignatureTokenException;
import com.example.helpmeassignment.global.exception.UnexpectedTokenException;
import com.example.helpmeassignment.global.security.jwt.properties.JwtProperties;
import com.example.helpmeassignment.global.security.principle.AuthDetailsService;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenParser {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    private static final String JWT_HEADER = "Authorization";
    private static final String JWT_PREFIX = "Bearer ";

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(JWT_HEADER);
        return parseToken(bearerToken);
    }

    public String parseToken(String token) {
        if (token != null && token.startsWith(JWT_PREFIX)) {
            return token.replace(JWT_PREFIX, "");
        } else return null;
    }

    private String getTokenSubject(String subject) {
        return parseTokenBody(subject).getSubject();
    }

    private Claims parseTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (SignatureException e) {
            throw SignatureTokenException.EXCEPTION;
        } catch (MalformedJwtException e) {
            throw JwtValidateException.EXCEPTION;
        } catch (Exception e) {
            throw UnexpectedTokenException.EXCEPTION;
        }
    }
}
