package com.example.helpmeassignment.domain.auth.domain.repository;

import com.example.helpmeassignment.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findRefreshToken(String refreshToken);
}
