package com.example.helpmeassignment.domain.use.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class UseResponse {
    private final String reason;
    private final Integer useAmount;
    private final LocalDate usedAt;
}
