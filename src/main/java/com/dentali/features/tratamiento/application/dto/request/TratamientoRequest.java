package com.dentali.features.tratamiento.application.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record TratamientoRequest(
        @NotNull(message = "El ID del paciente es obligatorio") Long pacienteId,

        Long citaId, // Opcional: se envía si el tratamiento se genera dentro de una cita específica

        @NotNull(message = "El ID del doctor es obligatorio") Long doctorId,

        @NotBlank(message = "La descripción del tratamiento no puede estar vacía") String descripcion,

        String observaciones, // Opcional: notas adicionales del odontólogo

        @NotNull(message = "El costo es obligatorio") @PositiveOrZero(message = "El costo no puede ser un valor negativo") BigDecimal costo) {

}
