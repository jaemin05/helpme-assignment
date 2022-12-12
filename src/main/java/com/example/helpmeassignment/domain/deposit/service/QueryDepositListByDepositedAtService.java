package com.example.helpmeassignment.domain.deposit.service;

import com.example.helpmeassignment.domain.deposit.domain.repository.DepositRepository;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositListResponse;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryDepositListByDepositedAtService {

    private final DepositRepository depositRepository;

    @Transactional(readOnly = true)
    public DepositListResponse execute(LocalDate startAt, LocalDate endAt, Integer page) {
        List<DepositResponse> list = depositRepository.queryAllDeposit(page)
                .stream()
                .filter(deposit -> timeFilter(deposit.getDepositedAt(), startAt, endAt))
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

    private Boolean timeFilter(LocalDate depositedAt, LocalDate startAt, LocalDate endAt) {
        return depositedAt.isAfter(startAt) && depositedAt.isBefore(endAt) ||
                depositedAt.isEqual(startAt) || depositedAt.isEqual(endAt);
    }
}
