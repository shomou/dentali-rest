package com.dentali.features.historial.domain.model.vo;

import java.util.Map;

public record AntecedentesFamiliares(
    Map<String, String> padecimientosFamiliares,
    String observaciones
) {

}
