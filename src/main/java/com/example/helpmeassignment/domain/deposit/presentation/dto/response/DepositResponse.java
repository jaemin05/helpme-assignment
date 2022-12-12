package com.example.helpmeassignment.domain.deposit.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class DepositResponse {
    private Integer memberNumber;
    private String memberName;
    private String departmentName;
    private Integer depositAmount;
    private LocalDate depositedAt;
}
