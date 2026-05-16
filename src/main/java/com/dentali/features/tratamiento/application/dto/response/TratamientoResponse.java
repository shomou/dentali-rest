package com.dentali.features.tratamiento.application.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.dentali.features.tratamiento.domain.enums.EstadoTratamiento;

public record TratamientoResponse(
        Long id,
        Long pacienteId,
        Long doctorId,
        Long citaId,
        LocalDateTime fecha,
        String descripcion,
        String observaciones,
        BigDecimal costo,
        EstadoTratamiento estado) {

}
