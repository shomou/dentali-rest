package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AntecedentesFamiliaresVO {
    private Map<String, String> padecimientosFamiliares;
    private String observaciones;
}

