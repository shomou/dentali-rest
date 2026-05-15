package com.dentali.features.auth.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record RegisterRequest(
    @NotBlank(message = "El nombre de usuario es obligatorio")
    String username,
    @NotBlank(message = "La contraseña es obligatoria")
    String password,
    @NotEmpty(message = "Debe asignar al menos un rol")
    List<String> roles
) {}