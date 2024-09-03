package com.sxntixgxs.survey.auth.application;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.auth.domain.AuthResponse;
import com.sxntixgxs.survey.auth.domain.LoginRequest;
import com.sxntixgxs.survey.auth.domain.RegisterRequest;
import com.sxntixgxs.survey.auth.domain.Role;
import com.sxntixgxs.survey.auth.domain.User;
import com.sxntixgxs.survey.auth.domain.ports.out.UserRepository;
import com.sxntixgxs.survey.jwt.application.JwtService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    public AuthResponse login(LoginRequest request){
        return null;
    }
    public AuthResponse register(RegisterRequest registerRequest){
        User user = User.builder()
            .username(registerRequest.getUsername())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .role(Role.USER)
            .build();
        userRepository.save(user);
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}
