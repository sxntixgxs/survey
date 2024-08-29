package com.sxntixgxs.survey.slices.user.domain.ports.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.sxntixgxs.survey.slices.user.domain.models.AppUser;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<AppUser> findByName(String name);
}
