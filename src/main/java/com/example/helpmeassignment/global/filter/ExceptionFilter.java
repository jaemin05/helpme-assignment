package com.example.helpmeassignment.global.filter;

import com.example.helpmeassignment.global.error.ErrorProperty;
import com.example.helpmeassignment.global.error.ErrorResponse;
import com.example.helpmeassignment.global.error.exception.CustomException;
import com.example.helpmeassignment.global.exception.InternalServerErrorException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (CustomException e) {
            errorToJson(e.getErrorProperty(), response);
        } catch (Exception e) {
            if (e.getCause().equals(CustomException.class)) {
                errorToJson(((CustomException) e.getCause()).getErrorProperty(), response);
            } else {
                errorToJson(InternalServerErrorException.EXCEPTION.getErrorProperty(), response);
                e.printStackTrace();
            }
        }
    }

    private void errorToJson(ErrorProperty errorProperty, HttpServletResponse response) throws IOException {
        response.setStatus(errorProperty.status());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                new ErrorResponse(errorProperty.status(), errorProperty.message()).toString());
    }
}
