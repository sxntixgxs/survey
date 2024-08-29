package com.sxntixgxs.survey.slices.user.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.slices.user.domain.models.AppUser;
import com.sxntixgxs.survey.slices.user.domain.ports.in.UserOperations;
import com.sxntixgxs.survey.slices.user.domain.ports.out.UserRepository;


@Service
public class UserService  implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optionalUser = userRepository.findByName(username);
        if(
            optionalUser.isPresent()
        ){
            AppUser user = optionalUser.get();
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRol())
                    .build();
        }else{
            throw new UsernameNotFoundException("User not found "+username);
        }
    }

    
}
