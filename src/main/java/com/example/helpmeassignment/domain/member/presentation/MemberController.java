package com.example.helpmeassignment.domain.member.presentation;

import com.example.helpmeassignment.domain.member.presentation.dto.request.RegisterMemberRequest;
import com.example.helpmeassignment.domain.member.presentation.dto.request.UpdateMemberRequest;
import com.example.helpmeassignment.domain.member.service.RegisterMemberService;
import com.example.helpmeassignment.domain.member.service.UpdateMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

    private final RegisterMemberService registerMemberService;
    private final UpdateMemberService updateMemberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void signupAdmin(@RequestBody @Valid RegisterMemberRequest request) {
        registerMemberService.execute(request);
    }

    @PostMapping("/{member-id}")
    public void loginAdmin(@PathVariable(name = "member-id") Integer memberId, @RequestBody @Valid UpdateMemberRequest request) {
        updateMemberService.execute(memberId, request);
    }
}
