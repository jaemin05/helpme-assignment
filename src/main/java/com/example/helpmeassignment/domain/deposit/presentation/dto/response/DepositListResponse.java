package com.example.helpmeassignment.domain.deposit.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class DepositListResponse {
    private List<DepositResponse> depositResponseList;
}
