package com.example.helpmeassignment.domain.member.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateMemberRequest {

    @NotBlank(message = "name은 필수 입력입니다.")
    private String name;

    @NotBlank(message = "position은 필수 입력입니다.")
    private String position;

    @NotBlank(message = "departmentName은 필수 입력입니다.")
    private String departmentName;
}
