package com.example.helpmeassignment.domain.deposit.service;

import com.example.helpmeassignment.domain.deposit.domain.repository.DepositRepository;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositListResponse;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositResponse;
import com.example.helpmeassignment.domain.member.domain.Member;
import com.example.helpmeassignment.domain.member.facade.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryDepositListByMemberService {

    private final DepositRepository depositRepository;
    private final MemberFacade memberFacade;

    @Transactional(readOnly = true)
    public DepositListResponse execute(Integer memberId, Integer page) {
        Member member = memberFacade.getMemberById(memberId);

        List<DepositResponse> list = depositRepository.queryAllDepositByMember(member, page)
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
