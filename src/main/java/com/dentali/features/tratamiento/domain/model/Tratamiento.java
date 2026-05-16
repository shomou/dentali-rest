package com.dentali.features.tratamiento.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.dentali.features.tratamiento.domain.enums.EstadoTratamiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tratamiento {

    private Long id;
    private Long pacienteId;
    private Long doctorId;
    private Long citaId;
    private LocalDateTime fecha;
    private String descripcion;
    private String observaciones;
    private BigDecimal costo;
    private EstadoTratamiento estado;

    // Comportamiento de negocio explícito
    public void completarTratamiento() {
        this.estado = EstadoTratamiento.COMPLETADO;
    }

}
