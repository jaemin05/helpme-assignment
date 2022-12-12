package com.example.helpmeassignment.domain.admin.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupAdminRequest {

    @NotBlank(message = "accountId는 필수 입력입니다.")
    private String accountId;

    @NotBlank(message = "name은 필수 입력입니다.")
    private String name;

    @NotBlank(message = "password는 필수 입력입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}$",
            message = "비밀번호는 영문자와 숫자, 특수문자를 모두 포함해서 8~16자리 이내로 입력해주세요.")
    private String password;

    @NotBlank(message = "rePassword는 필수 입력입니다.")
    private String rePassword;
}
