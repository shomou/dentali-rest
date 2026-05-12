package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterrogatorioSistemasVO {
    private String aparatoDigestivo;
    private String aparatoRespiratorio;
    private String aparatoCardiovascular;
    private String sistemaGenitourinario;
    private String sistemaEndocrino;
    private String sistemaHemopoyetico;
    private String sistemaNervioso;
    private String sistemaMusculoEsqueletico;
    private String tegumentos;
    private String observaciones;
}
