package com.sxntixgxs.survey.slices.user.domain.ports.out;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxntixgxs.survey.slices.user.domain.models.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> updateUser(User user);
}
