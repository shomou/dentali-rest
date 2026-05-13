package com.dentali.features.paciente.application.dto.response;

import com.dentali.features.paciente.domain.enums.Genero;
import com.dentali.features.paciente.domain.enums.EstadoPaciente;

public record PacienteResponse(
    Long id,
    String nombreCompleto,
    String identificacion,
    int edad,
    Genero genero,
    EstadoPaciente estado,
    String telefono,
    String email,
    String direccion
) {

}
