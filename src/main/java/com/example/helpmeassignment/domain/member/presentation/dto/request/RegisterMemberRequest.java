package com.example.helpmeassignment.domain.member.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RegisterMemberRequest {

    @NotBlank(message = "number는 필수 입력입니다.")
    @Size(min = 5, max = 5)
    private String number;

    @NotBlank(message = "name은 필수 입력입니다.")
    private String name;

    @NotBlank(message = "position은 필수 입력입니다.")
    private String position;

    @NotBlank(message = "departmentName은 필수 입력입니다.")
    private String departmentName;

    @NotNull(message = "joinedAt는 필수 입력입니다.")
    private LocalDate joinedAt;
}
