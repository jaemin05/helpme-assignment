package com.example.helpmeassignment.domain.admin.domain.repository;

import com.example.helpmeassignment.domain.admin.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

    Optional<Admin> findByAccountId(String accountId);

    Boolean existsByAccountId(String accountId);

    Boolean existsByName(String name);
}
