package com.example.helpmeassignment.domain.use.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UseListResponse {
    private final List<UseResponse> useResponseList;
}
