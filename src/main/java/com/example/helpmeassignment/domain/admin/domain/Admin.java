package com.example.helpmeassignment.domain.admin.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email
    @NotNull
    private String accountId;

    @NotNull
    private String name;

    @NotNull
    @Length(max = 60)
    private String password;

    @Builder
    public Admin(String accountId, String name, String password) {
        this.accountId = accountId;
        this.name = name;
        this.password = password;
    }
}
