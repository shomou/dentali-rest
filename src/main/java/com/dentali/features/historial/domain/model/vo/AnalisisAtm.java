package com.dentali.features.historial.domain.model.vo;

import java.util.Map;

import com.dentali.features.historial.domain.enums.SiNo;

public record AnalisisAtm(
    Map<Integer, SiNo> respuestasCuestionario,
    String observacionesOclusion,
    String ruidosArticulares,
    String fatigaMuscular,
    String desviacionMandibular
) {

}
