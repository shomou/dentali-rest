package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignosVitalesVO {
    private Double peso;
    private Double talla;
    private String grupoSanguineo;
    private String tensionArterial;
    private Integer frecuenciaRespiratoria;
    private Integer frecuenciaCardiaca;
    private Double temperatura;
    private Integer saturacionO2;

}
