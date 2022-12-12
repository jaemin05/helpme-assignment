package com.example.helpmeassignment.domain.member.facade;

import com.example.helpmeassignment.domain.member.domain.Member;
import com.example.helpmeassignment.domain.member.domain.repository.MemberRepository;
import com.example.helpmeassignment.domain.member.exception.properties.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MemberFacade {

    private final MemberRepository memberRepository;

    public Member getMemberById(Integer id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);
    }
}
