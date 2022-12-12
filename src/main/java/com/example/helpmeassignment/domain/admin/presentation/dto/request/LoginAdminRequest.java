package com.example.helpmeassignment.domain.admin.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginAdminRequest {

    @NotBlank(message = "accountId는 필수 입력입니다.")
    private String accountId;

    @NotBlank(message = "password는 필수 입력입니다.")
    private String password;
}
