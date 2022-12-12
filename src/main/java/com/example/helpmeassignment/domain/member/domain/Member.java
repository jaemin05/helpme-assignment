package com.example.helpmeassignment.domain.member.domain;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer number;

    @NotNull
    private String name;

    @NotNull
    private String position;

    @NotNull
    private String departmentName;

    @NotNull
    private LocalDate joinedAt;

    @NotNull
    private LocalDate registeredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Builder
    public Member(Integer number, String name, String position, String departmentName, LocalDate joinedAt, LocalDate registeredAt, Admin admin) {
        this.number = number;
        this.name = name;
        this.position = position;
        this.departmentName = departmentName;
        this.joinedAt = joinedAt;
        this.registeredAt = registeredAt;
        this.admin = admin;
    }

    public void updateMember(String name, String position, String departmentName) {
        this.name = name;
        this.position = position;
        this.departmentName = departmentName;
    }
}
