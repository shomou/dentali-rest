package com.dentali.features.doctor.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DoctorRegistrationRequest(
    @NotBlank(message = "El nombre es obligatorio")
    String nombre,
    @NotBlank(message = "El apellido es obligatorio")
    String apellido,
    @NotBlank(message = "La especialidad es obligatoria")
    String especialidad,
    String telefono,
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    String email,
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    String password
) {}