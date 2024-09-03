package com.sxntixgxs.survey.auth.domain.ports.out;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sxntixgxs.survey.auth.domain.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
}
