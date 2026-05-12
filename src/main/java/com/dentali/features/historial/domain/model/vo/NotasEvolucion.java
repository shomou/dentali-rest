package com.dentali.features.historial.domain.model.vo;

import java.time.LocalDateTime;

public record NotasEvolucion(
    LocalDateTime fecha,
    String diagnostico,
    String tratamientoRealizado,
    String observaciones,
    SignosVitales signosVitalesAlMomento
) {

}
