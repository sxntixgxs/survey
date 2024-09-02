package com.sxntixgxs.survey.slices.loggin.domain.ports.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxntixgxs.survey.slices.loggin.domain.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
}
