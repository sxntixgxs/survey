package com.sxntixgxs.survey.slices.user.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.slices.user.domain.models.User;
import com.sxntixgxs.survey.slices.user.domain.ports.in.UserOperations;
import com.sxntixgxs.survey.slices.user.domain.ports.out.UserRepository;

@Service
public class UserServiceImp implements UserOperations{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void createRole(User user) {
        if(
            userRepository.existsById(user.getId())
        ){
            userRepository.save(user);
        }
    }
    @Override
    public Optional<User> getUserById(int id) {
        if(
            userRepository.existsById(id)
        ){
            return Optional.of(userRepository.findById(id).get());
        }else{
            return Optional.empty();
        }
    }
    @Override
    public Optional<User> updateUser(User user) {
        if(
            userRepository.existsById(user.getId())
        ){
            return Optional.of(userRepository.save(user));
        }else{
            return Optional.empty();
        }
    }
    @Override
    public void deleteUser(int id) {
        if(
            userRepository.existsById(id)
        ){
            userRepository.deleteById(id);
        }
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
