package com.example.helpmeassignment.global.security;

import com.example.helpmeassignment.global.filter.ExceptionFilter;
import com.example.helpmeassignment.global.security.jwt.JwtTokenFilter;
import com.example.helpmeassignment.global.security.jwt.JwtTokenParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenParser jwtTokenParser;
    private final ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity http) {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenParser);
        ExceptionFilter exceptionFilter = new ExceptionFilter(objectMapper);

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(exceptionFilter, JwtTokenFilter.class);
    }
}
