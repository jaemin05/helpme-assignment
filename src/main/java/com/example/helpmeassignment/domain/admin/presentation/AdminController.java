package com.example.helpmeassignment.domain.admin.presentation;

import com.example.helpmeassignment.domain.admin.presentation.dto.request.LoginAdminRequest;
import com.example.helpmeassignment.domain.admin.presentation.dto.request.SignupAdminRequest;
import com.example.helpmeassignment.domain.admin.service.LoginService;
import com.example.helpmeassignment.domain.admin.service.SignupService;
import com.example.helpmeassignment.domain.auth.presentation.dto.response.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/admin")
@RestController
public class AdminController {

    private final SignupService signupService;
    private final LoginService loginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signupAdmin(@RequestBody @Valid SignupAdminRequest request) {
        signupService.execute(request);
    }

    @PostMapping("/login")
    public TokenResponse loginAdmin(@RequestBody @Valid LoginAdminRequest request) {
        return loginService.execute(request);
    }
}
