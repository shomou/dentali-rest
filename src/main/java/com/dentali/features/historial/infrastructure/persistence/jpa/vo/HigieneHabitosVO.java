package com.dentali.features.historial.infrastructure.persistence.jpa.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HigieneHabitosVO {
    private Integer frecuenciaCepillado;
    private List<String> auxiliares; 
    private String consumeGolosinas; 
    private String fuma;
    private String consumeAlcohol;
    private String frecuenciaHigieneBucal;
}
