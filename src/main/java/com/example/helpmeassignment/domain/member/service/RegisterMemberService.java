package com.example.helpmeassignment.domain.member.service;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import com.example.helpmeassignment.domain.admin.facade.AdminFacade;
import com.example.helpmeassignment.domain.member.domain.Member;
import com.example.helpmeassignment.domain.member.domain.repository.MemberRepository;
import com.example.helpmeassignment.domain.member.presentation.dto.request.RegisterMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class RegisterMemberService {

    private final MemberRepository memberRepository;
    private final AdminFacade adminFacade;

    @Transactional
    public void execute(RegisterMemberRequest request) {
        Admin admin = adminFacade.getCurrentAdmin();
        Integer number = Integer.parseInt(request.getNumber());

        memberRepository.save(
                Member.builder()
                        .number(number)
                        .name(request.getName())
                        .position(request.getPosition())
                        .departmentName(request.getDepartmentName())
                        .joinedAt(request.getJoinedAt())
                        .registeredAt(LocalDate.now())
                        .admin(admin)
                        .build());
    }
}
