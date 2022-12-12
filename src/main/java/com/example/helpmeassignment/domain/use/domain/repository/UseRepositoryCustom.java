package com.example.helpmeassignment.domain.use.domain.repository;

import com.example.helpmeassignment.domain.use.domain.Use;

import java.util.List;

public interface UseRepositoryCustom {
    List<Use> queryAllUse(Integer page);
}
