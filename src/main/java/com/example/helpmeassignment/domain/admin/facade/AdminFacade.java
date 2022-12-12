package com.example.helpmeassignment.domain.admin.facade;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import com.example.helpmeassignment.domain.admin.domain.repository.AdminRepository;
import com.example.helpmeassignment.domain.admin.exception.AdminNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminFacade {

    private final AdminRepository adminRepository;

    public Admin getCurrentAdmin() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByAccountId(accountId);
    }

    public Admin getUserByAccountId(String accountId) {
        return adminRepository.findByAccountId(accountId)
                .orElseThrow(() -> AdminNotFoundException.EXCEPTION);
    }
}
