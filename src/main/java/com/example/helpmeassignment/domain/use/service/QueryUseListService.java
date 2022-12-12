package com.example.helpmeassignment.domain.use.service;

import com.example.helpmeassignment.domain.use.domain.repository.UseRepository;
import com.example.helpmeassignment.domain.use.presentation.dto.response.UseListResponse;
import com.example.helpmeassignment.domain.use.presentation.dto.response.UseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QueryUseListService {

    private final UseRepository useRepository;

    @Transactional(readOnly = true)
    public UseListResponse execute(Integer page) {
        List<UseResponse> list = useRepository.queryAllUse(page)
                .stream()
                .map(use -> UseResponse.builder()
                        .reason(use.getReason())
                        .useAmount(use.getUseAmount())
                        .usedAt(use.getUsedAt())
                        .build())
                .toList();

        return new UseListResponse(list);
    }
}
