package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaEvolucionVO {
    private LocalDateTime fecha;
    private String diagnostico;
    private String tratamientoRealizado;
    private String observaciones;
    private SignosVitalesVO signosVitalesAlMomento; // El Word pide signos en cada nota
}
