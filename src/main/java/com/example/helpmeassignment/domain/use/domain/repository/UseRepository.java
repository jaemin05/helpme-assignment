package com.example.helpmeassignment.domain.use.domain.repository;

import com.example.helpmeassignment.domain.use.domain.Use;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseRepository extends CrudRepository<Use, Integer>, UseRepositoryCustom {
}
