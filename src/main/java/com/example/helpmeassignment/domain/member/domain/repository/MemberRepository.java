package com.example.helpmeassignment.domain.member.domain.repository;

import com.example.helpmeassignment.domain.member.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
}
