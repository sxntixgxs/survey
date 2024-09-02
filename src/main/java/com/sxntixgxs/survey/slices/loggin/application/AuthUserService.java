package com.sxntixgxs.survey.slices.loggin.application;

import com.sxntixgxs.survey.slices.loggin.domain.ports.in.AuthUserUseCase;


@Service
@RequiredArgsConstructor
public class AuthUserService implements AuthUserUseCase{
    private final AppUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse login(LoginRequest request){
        return null;
    }
    public AuthResponse register(RegisterRequest request){
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(request.getRoles())
            .build();
        userRepository.save(user);
        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
    }
}
