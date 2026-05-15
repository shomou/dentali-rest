package com.dentali.features.cita.application.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record CitaRequest(
    Long pacienteId,
    Long doctorId,
    @Future
    @NotNull
    LocalDateTime fecha_hora,
    String motivo,
    String estado,
    String observaciones
) {

}
