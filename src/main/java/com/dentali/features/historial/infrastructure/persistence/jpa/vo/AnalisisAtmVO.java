package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalisisAtmVO {
    private java.util.Map<Integer, String> respuestasCuestionario;
    private String observacionesOclusion;
    private String ruidosArticulares;
    private String fatigaMuscular;
    private String desviacionMandibular;
    
}
