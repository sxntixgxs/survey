package com.sxntixgxs.survey.auth.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxntixgxs.survey.auth.application.AuthService;
import com.sxntixgxs.survey.auth.domain.AuthResponse;
import com.sxntixgxs.survey.auth.domain.LoginRequest;
import com.sxntixgxs.survey.auth.domain.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/login")
    public String showLoginPage(){
        return "auth/login.html";
    }
    @GetMapping("/register")
    public String showRegisterPage(){
        return "auth/register.html";
    }

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
}
