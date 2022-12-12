package com.example.helpmeassignment.domain.deposit.presentation;

import com.example.helpmeassignment.domain.deposit.presentation.dto.request.SaveDepositRequest;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositListResponse;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.TotalDepositAmountResponse;
import com.example.helpmeassignment.domain.deposit.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/deposit")
@RestController
public class DepositController {

    private final SaveDepositService saveDepositService;
    private final QueryDepositListService queryDepositListService;
    private final QueryDepositListByMemberService queryDepositListByMemberService;
    private final QueryTotalDepositAmountService queryTotalDepositAmountService;
    private final QueryDepositListByDepositedAtService queryDepositListByDepositedAtService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveDeposit(@RequestBody @Valid SaveDepositRequest request) {
        saveDepositService.execute(request);
    }

    @GetMapping
    public DepositListResponse queryDepositList(@RequestParam Integer page) {
        return queryDepositListService.execute(page);
    }

    @GetMapping("/{member-id}")
    public DepositListResponse queryDepositList(@PathVariable("member-id") Integer memberId, @RequestParam Integer page) {
        return queryDepositListByMemberService.execute(memberId, page);
    }

    @GetMapping("/total")
    public TotalDepositAmountResponse queryTotalDepositAmount() {
        return queryTotalDepositAmountService.execute();
    }

    @GetMapping("/time")
    public DepositListResponse queryDepositList(@RequestParam LocalDate startAt, @RequestParam LocalDate endAt, @RequestParam Integer page) {
        return queryDepositListByDepositedAtService.execute(startAt, endAt, page);
    }
}
