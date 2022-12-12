package com.example.helpmeassignment.domain.deposit.domain.repository;

import com.example.helpmeassignment.domain.deposit.domain.repository.vo.DepositVO;
import com.example.helpmeassignment.domain.member.domain.Member;

import java.util.List;

public interface DepositRepositoryCustom {
    List<DepositVO> queryAllDeposit(Integer page);

    List<DepositVO> queryAllDepositByMember(Member keyMember, Integer page);
}
