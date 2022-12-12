package com.example.helpmeassignment.domain.deposit.domain.repository;

import com.example.helpmeassignment.domain.deposit.domain.Deposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Integer>, DepositRepositoryCustom {
    List<Deposit> findAllBy();
}
