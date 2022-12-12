package com.example.helpmeassignment.domain.deposit.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveDepositRequest {

    @NotNull(message = "memberId는 필수 입력입니다.")
    private Integer memberId;

    @NotNull(message = "depositAmount은 필수 입력입니다.")
    private Integer depositAmount;
}
