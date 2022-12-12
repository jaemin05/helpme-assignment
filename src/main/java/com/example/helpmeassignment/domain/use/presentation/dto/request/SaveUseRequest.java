package com.example.helpmeassignment.domain.use.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SaveUseRequest {

    @NotBlank(message = "reason은 필수 입력입니다.")
    private String reason;

    @NotNull(message = "useAmount는 필수 입력입니다.")
    private Integer useAmount;

    @NotNull(message = "usedAt는 필수 입력입니다.")
    private LocalDate usedAt;
}
