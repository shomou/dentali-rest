package com.dentali.features.auth.application.service;

import java.util.List;
import com.dentali.features.auth.application.dto.request.LoginRequest;
import com.dentali.features.auth.application.dto.response.AuthResponse;
import com.dentali.features.auth.application.dto.response.UserResponse;
import com.dentali.features.auth.domain.model.User;

public interface AuthService {
    User registrarUsuario(String username, String password, List<String> roleNames);
    AuthResponse login(LoginRequest loginRequest);
    List<UserResponse> listarUsuarios();
    UserResponse buscarPorUsername(String username);
    void actualizarUsername(String oldUsername, String newUsername);
    void eliminarUsuario(String username);
    List<String> obtenerRolesPorUsername(String username);
    boolean existeUsuario(String username);
}