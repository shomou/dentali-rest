package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalisisOclusionVO {

    private String lineaMedia;
    private String relacionMolarDerecha;
    private String relacionMolarIzquierda;
    private String relacionCaninaDerecha;
    private String relacionCaninaIzquierda;
    private Double sobremordidaVertical;
    private Double sobremordidaHorizontal;
    private String mordidaAbierta; // "SI" / "NO"
    private String mordidaCruzada; // "SI" / "NO"

}
