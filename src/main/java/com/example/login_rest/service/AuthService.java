package com.example.login_rest.service;

import com.example.login_rest.config.JWTUtil;
import com.example.login_rest.dto.ResponseLoginUser;
import com.example.login_rest.dto.RequestLoginProxy;
import com.example.login_rest.dto.RequestRegisterUser;
import com.example.login_rest.dto.ResponseRegisterUserProxy;
import com.example.login_rest.model.User;
import com.example.login_rest.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public AuthService(UserRepository userRepository, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    public ResponseRegisterUserProxy register(RequestRegisterUser request) {
        Optional<User> existingUser = userRepository.findByUsername(request.getUsername());
        if (existingUser.isPresent()) {
            return new ResponseRegisterUserProxy("User already exist.");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User newUser = new User(null, request.getUsername(), hashedPassword);
        userRepository.save(newUser);
        return new ResponseRegisterUserProxy("User register c:");
    }

    public ResponseLoginUser login(RequestLoginProxy request) {
        return userRepository.findByUsername(request.getUsername())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(user -> new ResponseLoginUser("User authenticated successfully", jwtUtil.generateToken(user.getUsername())))
                .orElse(new ResponseLoginUser("Invalid username or password", null));
    }
}
