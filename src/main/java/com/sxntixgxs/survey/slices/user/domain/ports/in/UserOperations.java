package com.sxntixgxs.survey.slices.user.domain.ports.in;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sxntixgxs.survey.slices.user.domain.models.User;

@Repository
public interface UserOperations {
    void createRole(User user);
    Optional<User> getUserById(int id);
    Optional<User> updateUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}
