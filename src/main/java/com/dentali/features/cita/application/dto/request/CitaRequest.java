package com.dentali.features.cita.application.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record CitaRequest(
    Long paciente_id,
    Long doctor_id,
    @Future
    @NotNull
    String fecha_hora,
    String motivo,
    String estado,
    String observaciones
) {

}
