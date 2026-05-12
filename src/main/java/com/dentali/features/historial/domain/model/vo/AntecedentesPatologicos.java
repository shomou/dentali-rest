package com.dentali.features.historial.domain.model.vo;

import java.util.Map;

import com.dentali.features.historial.domain.enums.SiNo;

public record AntecedentesPatologicos(
    String enfermedadesUltimoAno,
    Map<String, SiNo> padecimientos,
    String observaciones
) {

}
