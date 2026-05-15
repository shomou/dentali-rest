package com.dentali.features.auth.interfaces.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.dentali.features.auth.application.dto.request.LoginRequest;
import com.dentali.features.auth.application.dto.request.RegisterRequest;
import com.dentali.features.auth.application.dto.response.AuthResponse;
import com.dentali.features.auth.application.dto.response.UserResponse;
import com.dentali.features.auth.application.service.AuthService;
import com.dentali.features.auth.domain.model.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest request) {
        User newUser = authService.registrarUsuario(request.username(), request.password(), request.roles());
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listar() {
        return ResponseEntity.ok(authService.listarUsuarios());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> buscarPorUsername(@PathVariable String username) {
        return ResponseEntity.ok(authService.buscarPorUsername(username));
    }
}