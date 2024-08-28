package com.sxntixgxs.survey.slices.user.domain.ports.in;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sxntixgxs.survey.slices.user.domain.models.User;

@Repository
public interface UserOperations {
    public User findByName(String name);
    
}
