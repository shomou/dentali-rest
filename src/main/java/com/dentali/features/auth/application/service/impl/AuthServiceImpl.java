package com.dentali.features.auth.application.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.core.exceptions.ResourceNotFoundException;
import com.dentali.features.auth.application.dto.request.LoginRequest;
import com.dentali.features.auth.application.dto.response.AuthResponse;
import com.dentali.features.auth.application.dto.response.UserResponse;
import com.dentali.features.auth.application.mapper.AuthMapper;
import com.dentali.features.auth.application.service.AuthService;
import com.dentali.features.auth.domain.model.Role;
import com.dentali.features.auth.domain.model.User;
import com.dentali.features.auth.domain.repository.RoleRepository;
import com.dentali.features.auth.domain.repository.UserRepository;
import com.dentali.features.auth.infrastructure.security.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    private final AuthMapper authMapper;

    @Override
    @Transactional
    public User registrarUsuario(String username, String password, List<String> roleNames) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        Set<Role> roles = new HashSet<>();
        roleNames.forEach(name -> roleRepository.findByName(name).ifPresent(roles::add));
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));
        
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + username));

        String token = jwtService.generateToken(username);
        return authMapper.toResponse(user, token);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> listarUsuarios() {
        return userRepository.findAll().stream()
                .map(authMapper::toUserResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse buscarPorUsername(String username) {
        return userRepository.findByUsername(username)
                .map(authMapper::toUserResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + username));
    }

    @Override
    @Transactional
    public void actualizarUsername(String oldUsername, String newUsername) {
        userRepository.findByUsername(oldUsername).ifPresent(user -> {
            user.setUsername(newUsername);
            userRepository.save(user);
        });
    }

    @Override
    @Transactional
    public void eliminarUsuario(String username) {
        userRepository.findByUsername(username).ifPresent(userRepository::delete);
    }

    @Override
    public List<String> obtenerRolesPorUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> user.getRoles().stream().map(Role::getName).toList())
                .orElse(List.of());
    }

    @Override
    public boolean existeUsuario(String username) {
        return userRepository.existsByUsername(username);
    }
}