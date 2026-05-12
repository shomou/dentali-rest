package com.dentali.features.historial.domain.model.vo;

import com.dentali.features.historial.domain.enums.SiNo;

public record AnalisisOclusion(
    String lineaMedia,
    String relacionMolarDerecha,
    String relacionMolarIzquierda,
    String relacionCaninaDerecha,
    String relacionCaninaIzquierda,
    Double sobremordidaVertical,   
    Double sobremordidaHorizontal, 
    SiNo mordidaAbierta,
    SiNo mordidaCruzada
) {

}
