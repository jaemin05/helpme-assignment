package com.example.helpmeassignment.domain.use.service;

import com.example.helpmeassignment.domain.use.domain.repository.UseRepository;
import com.example.helpmeassignment.domain.use.presentation.dto.response.UseListResponse;
import com.example.helpmeassignment.domain.use.presentation.dto.response.UseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryUseListByUsedAtService {

    private final UseRepository useRepository;

    @Transactional(readOnly = true)
    public UseListResponse execute(LocalDate startAt, LocalDate endAt, Integer page) {
        List<UseResponse> list = useRepository.queryAllUse(page)
                .stream()
                .filter(use -> timeFilter(use.getUsedAt(), startAt, endAt))
                .map(use -> UseResponse.builder()
                        .reason(use.getReason())
                        .useAmount(use.getUseAmount())
                        .usedAt(use.getUsedAt())
                        .build())
                .toList();

        return new UseListResponse(list);
    }


    private Boolean timeFilter(LocalDate depositedAt, LocalDate startAt, LocalDate endAt) {
        return depositedAt.isAfter(startAt) && depositedAt.isBefore(endAt) ||
                depositedAt.isEqual(startAt) || depositedAt.isEqual(endAt);
    }
}
