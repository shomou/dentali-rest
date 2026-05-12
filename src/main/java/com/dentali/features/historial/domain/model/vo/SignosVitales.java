package com.dentali.features.historial.domain.model.vo;

import com.dentali.features.historial.domain.enums.GrupoSanguineo;

public record SignosVitales(
    Double peso,
    Double talla,
    GrupoSanguineo grupoSanguineo,
    String tensionArterial,
    Integer frecuenciaRespiratoria,
    Integer frecuenciaCardiaca,
    Double temperatura,
    Integer saturacionO2
) {

}
