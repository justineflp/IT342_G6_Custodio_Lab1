package com.it342.auth.service;

import com.it342.auth.dto.AuthResponse;
import com.it342.auth.dto.LoginRequest;
import com.it342.auth.dto.RegisterRequest;
import com.it342.auth.entity.User;
import com.it342.auth.repository.UserRepository;
import com.it342.auth.security.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final com.it342.auth.security.JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       com.it342.auth.security.JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }
        User user = new User(
                request.getEmail(),
                request.getFullName(),
                passwordEncoder.encode(request.getPassword())
        );
        user = userRepository.save(user);
        UserPrincipal principal = UserPrincipal.create(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
        String token = jwtUtil.generateToken(auth);
        return new AuthResponse(token, user.getId(), user.getEmail(), user.getFullName());
    }

    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        User user = userRepository.findById(principal.getId()).orElseThrow();
        String token = jwtUtil.generateToken(authentication);
        return new AuthResponse(token, user.getId(), user.getEmail(), user.getFullName());
    }
}
