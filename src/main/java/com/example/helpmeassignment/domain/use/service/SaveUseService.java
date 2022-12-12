package com.example.helpmeassignment.domain.use.service;

import com.example.helpmeassignment.domain.deposit.presentation.dto.response.TotalDepositAmountResponse;
import com.example.helpmeassignment.domain.deposit.service.QueryTotalDepositAmountService;
import com.example.helpmeassignment.domain.use.domain.Use;
import com.example.helpmeassignment.domain.use.domain.repository.UseRepository;
import com.example.helpmeassignment.domain.use.exception.IsTooBigUseAmountException;
import com.example.helpmeassignment.domain.use.presentation.dto.request.SaveUseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SaveUseService {

    private final UseRepository useRepository;
    private final QueryTotalDepositAmountService queryTotalDepositAmountService;

    @Transactional
    public void execute(SaveUseRequest request) {
        TotalDepositAmountResponse response = queryTotalDepositAmountService.execute();

        if (request.getUseAmount() > response.getTotalDepositAmount()) {
            throw IsTooBigUseAmountException.EXCEPTION;
        }

        useRepository.save(
                Use.builder()
                        .reason(request.getReason())
                        .useAmount(request.getUseAmount())
                        .usedAt(request.getUsedAt())
                        .build());
    }
}
