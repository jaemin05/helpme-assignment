package com.example.helpmeassignment.domain.deposit.domain.repository;

import com.example.helpmeassignment.domain.deposit.domain.repository.vo.DepositVO;
import com.example.helpmeassignment.domain.deposit.domain.repository.vo.QDepositVO;
import com.example.helpmeassignment.domain.member.domain.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.helpmeassignment.domain.deposit.domain.QDeposit.deposit;
import static com.example.helpmeassignment.domain.member.domain.QMember.member;

@RequiredArgsConstructor
public class DepositRepositoryCustomImpl implements DepositRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public List<DepositVO> queryAllDeposit(Integer page) {
        long size = 8;
        return query
                .select(
                        new QDepositVO(
                                member.number,
                                member.name,
                                member.departmentName,
                                deposit.depositAmount,
                                deposit.depositedAt
                        )
                )
                .from(deposit)
                .leftJoin(member)
                .on(deposit.member.eq(member))
                .orderBy(member.number.asc())
                .offset((long) page * size)
                .limit(size)
                .fetch();
    }

    @Override
    public List<DepositVO> queryAllDepositByMember(Member keyMember, Integer page) {
        long size = 8;
        return query
                .select(
                        new QDepositVO(
                                member.number,
                                member.name,
                                member.departmentName,
                                deposit.depositAmount,
                                deposit.depositedAt
                        )
                )
                .from(deposit)
                .leftJoin(member)
                .on(deposit.member.eq(member))
                .where(deposit.member.eq(keyMember))
                .orderBy(member.number.asc())
                .offset((long) page * size)
                .limit(size)
                .fetch();
    }
}
