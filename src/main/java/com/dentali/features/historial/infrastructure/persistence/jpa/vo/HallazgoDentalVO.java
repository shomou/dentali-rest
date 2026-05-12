package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HallazgoDentalVO {
    private Integer numeroDiente;
    private String cara;
    private String condicion;
    private String observaciones;
}