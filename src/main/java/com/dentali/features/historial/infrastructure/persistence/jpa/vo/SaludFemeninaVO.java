package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaludFemeninaVO {
    private String estaEmbarazada;
    private Integer mesesEmbarazo;
    private String estaLactando;
    private String tomaAnticonceptivos;
    private String observaciones;
}
