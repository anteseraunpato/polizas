package com.example.login_rest.controllers;

import com.example.login_rest.dto.RequestLoginProxy;
import com.example.login_rest.dto.RequestRegisterUser;
import com.example.login_rest.dto.ResponseLoginUser;
import com.example.login_rest.dto.ResponseRegisterUserProxy;
import com.example.login_rest.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseRegisterUserProxy> register(@RequestBody RequestRegisterUser request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginUser> login(@RequestBody RequestLoginProxy request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
