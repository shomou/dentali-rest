package com.dentali.features.paciente.application.dto.request;

import java.time.LocalDate;

import com.dentali.features.paciente.domain.enums.Genero;

public record PacienteRequest(
    String nombre,
    String apellido,
    String identificacion,
    LocalDate fechaNacimiento,
    Genero genero,
    String telefono,
    String email,
    String direccion
) {
    
}
