package com.dentali.features.historial.domain.model.vo;

import java.util.List;

import com.dentali.features.historial.domain.enums.AuxiliarHigiene;
import com.dentali.features.historial.domain.enums.SiNo;

public record HigieneHabitos(
    Integer frecuenciaCepillado,
    List<AuxiliarHigiene> auxiliares,
    SiNo consumeGolosinas,
    SiNo fuma,
    SiNo consumeAlcohol,
    String frecuenciaHigieneBucal
) {

}
