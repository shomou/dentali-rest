package com.dentali.features.cita.application.dto.response;

public record CitaResponse(
    Long id,
    String nombrePaciente,
    String nombreDoctor,
    String fecha_hora,
    String motivo,
    String estado,
    String observaciones
) {

}
