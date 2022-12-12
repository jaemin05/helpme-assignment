package com.example.helpmeassignment.domain.deposit.service;

import com.example.helpmeassignment.domain.deposit.domain.Deposit;
import com.example.helpmeassignment.domain.deposit.domain.repository.DepositRepository;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.TotalDepositAmountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryTotalDepositAmountService {

    private final DepositRepository depositRepository;

    @Transactional(readOnly = true)
    public TotalDepositAmountResponse execute() {
        int totalDeposit = 0;

        List<Deposit> lists = depositRepository.findAllBy();

        for (Deposit deposit : lists) {
            totalDeposit += deposit.getDepositAmount();
        }

        return new TotalDepositAmountResponse(totalDeposit);
    }
}
