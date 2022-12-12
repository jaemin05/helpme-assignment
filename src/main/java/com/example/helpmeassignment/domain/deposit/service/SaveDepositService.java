package com.example.helpmeassignment.domain.deposit.service;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import com.example.helpmeassignment.domain.admin.facade.AdminFacade;
import com.example.helpmeassignment.domain.deposit.domain.Deposit;
import com.example.helpmeassignment.domain.deposit.domain.repository.DepositRepository;
import com.example.helpmeassignment.domain.deposit.presentation.dto.request.SaveDepositRequest;
import com.example.helpmeassignment.domain.member.domain.Member;
import com.example.helpmeassignment.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class SaveDepositService {

    private final DepositRepository depositRepository;
    private final MemberFacade memberFacade;
    private final AdminFacade adminFacade;

    @Transactional
    public void execute(SaveDepositRequest request) {
        Admin admin = adminFacade.getCurrentAdmin();
        Member member = memberFacade.getMemberById(request.getMemberId());

        depositRepository.save(
                Deposit.builder()
                        .depositAmount(request.getDepositAmount())
                        .depositedAt(LocalDate.now())
                        .admin(admin)
                        .member(member)
                        .build());
    }
}
