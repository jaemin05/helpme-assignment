package com.example.helpmeassignment.domain.deposit.domain;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import com.example.helpmeassignment.domain.member.domain.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_deposit")
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer depositAmount;

    @NotNull
    private LocalDate depositedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @Builder
    public Deposit(Integer depositAmount, LocalDate depositedAt, Admin admin, Member member) {
        this.depositAmount = depositAmount;
        this.depositedAt = depositedAt;
        this.admin = admin;
        this.member = member;
    }
}
