package com.example.helpmeassignment.domain.use.domain;

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
@Table(name = "tbl_use")
public class Use {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String reason;

    @NotNull
    private Integer useAmount;

    @NotNull
    private LocalDate usedAt;

    @Builder
    public Use(String reason, Integer useAmount, LocalDate usedAt) {
        this.reason = reason;
        this.useAmount = useAmount;
        this.usedAt = usedAt;
    }
}
