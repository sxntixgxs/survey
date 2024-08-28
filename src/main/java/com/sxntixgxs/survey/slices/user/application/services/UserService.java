package com.sxntixgxs.survey.slices.user.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.slices.user.domain.models.User;
import com.sxntixgxs.survey.slices.user.domain.ports.in.UserOperations;
import com.sxntixgxs.survey.slices.user.domain.ports.out.UserRepository;

@Service
public class UserService  implements UserOperations{
    private final UserRepository repository;
    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createRole(User user) {
        repository.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        if(
            repository.findById(id).isPresent()
        ){
            return Optional.of(repository.findById(id).get());
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> updateUser(User user) {
        if(
            repository.existsById(user.getId())
        ){
            return Optional.of(repository.save(user));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public void deleteUser(int id) {
        if(
            repository.existsById(id)
        ){
            repository.deleteById(id);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    
}
