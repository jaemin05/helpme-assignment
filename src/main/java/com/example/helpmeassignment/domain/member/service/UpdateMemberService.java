package com.example.helpmeassignment.domain.member.service;

import com.example.helpmeassignment.domain.member.domain.Member;
import com.example.helpmeassignment.domain.member.facade.MemberFacade;
import com.example.helpmeassignment.domain.member.presentation.dto.request.UpdateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateMemberService {

    private final MemberFacade memberFacade;

    @Transactional
    public void execute(Integer memberId, UpdateMemberRequest request) {
        Member member = memberFacade.getMemberById(memberId);

        member.updateMember(
                request.getName(),
                request.getPosition(),
                request.getDepartmentName()
        );
    }
}
