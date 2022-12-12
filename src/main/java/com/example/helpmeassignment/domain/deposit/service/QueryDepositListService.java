package com.example.helpmeassignment.domain.deposit.service;

import com.example.helpmeassignment.domain.deposit.domain.repository.DepositRepository;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositListResponse;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryDepositListService {

    private final DepositRepository depositRepository;

    @Transactional(readOnly = true)
    public DepositListResponse execute(Integer page) {
        List<DepositResponse> list = depositRepository.queryAllDeposit(page)
                .stream()
                .map(deposit ->
                        DepositResponse.builder()
                                .memberNumber(deposit.getMemberNumber())
                                .memberName(deposit.getMemberName())
                                .departmentName(deposit.getDepartmentName())
                                .depositAmount(deposit.getDepositAmount())
                                .depositedAt(deposit.getDepositedAt())
                                .build())
                .toList();

        return new DepositListResponse(list);
    }
}
