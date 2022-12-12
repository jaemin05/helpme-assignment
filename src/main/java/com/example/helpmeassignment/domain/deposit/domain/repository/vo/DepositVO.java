package com.example.helpmeassignment.domain.deposit.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class DepositVO {

    private final Integer memberNumber;
    private final String memberName;
    private final String departmentName;
    private final Integer depositAmount;
    private final LocalDate depositedAt;

    @QueryProjection
    public DepositVO(Integer memberNumber, String memberName, String departmentName, Integer depositAmount, LocalDate depositedAt) {
        this.memberNumber = memberNumber;
        this.memberName = memberName;
        this.departmentName = departmentName;
        this.depositAmount = depositAmount;
        this.depositedAt = depositedAt;
    }
}
