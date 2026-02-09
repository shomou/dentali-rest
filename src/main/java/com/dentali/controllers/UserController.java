package com.dentali.controllers;

import java.util.List;
import java.util.Map;

import com.dentali.dto.UserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.dto.LoginRequestDTO;
import com.dentali.dto.UserDoctorRegistrationDTO;
import com.dentali.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequest) {
        // La lógica de try-catch ahora es manejada por GlobalExceptionHandler
        String token = userService.verify(loginRequest);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserResponseDTO>> list() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserDoctorRegistrationDTO userDoctorRegistrationDTO) {

        UserDoctorRegistrationDTO registeredUser = userService.registerUserWithDoctor(userDoctorRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }

}
