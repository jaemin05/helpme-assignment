package com.example.helpmeassignment.domain.use.domain.repository;

import com.example.helpmeassignment.domain.use.domain.Use;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.helpmeassignment.domain.use.domain.QUse.use;

@RequiredArgsConstructor
public class UseRepositoryCustomImpl implements UseRepositoryCustom {

    private final JPAQueryFactory query;

    @Override
    public List<Use> queryAllUse(Integer page) {
        long size = 8;
        return query
                .selectFrom(use)
                .offset((long) page * size)
                .limit(size)
                .fetch();
    }
}
