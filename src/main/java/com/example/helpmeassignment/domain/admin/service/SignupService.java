package com.example.helpmeassignment.domain.admin.service;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import com.example.helpmeassignment.domain.admin.domain.repository.AdminRepository;
import com.example.helpmeassignment.domain.admin.exception.AccountIdAlreadyExistsException;
import com.example.helpmeassignment.domain.admin.exception.NameAlreadyExistsException;
import com.example.helpmeassignment.domain.admin.exception.PasswordMissMatchedException;
import com.example.helpmeassignment.domain.admin.presentation.dto.request.SignupAdminRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignupService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(SignupAdminRequest request) {

        if (adminRepository.existsByAccountId(request.getAccountId())) {
            throw AccountIdAlreadyExistsException.EXCEPTION;
        }

        if (adminRepository.existsByName(request.getName())) {
            throw NameAlreadyExistsException.EXCEPTION;
        }

        if (!request.getPassword().equals(request.getRePassword())) {
            throw PasswordMissMatchedException.EXCEPTION;
        }

        adminRepository.save(
                Admin.builder()
                        .accountId(request.getAccountId())
                        .name(request.getName())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build());
    }
}
