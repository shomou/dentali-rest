package com.dentali.features.historial.domain.model.vo;

import com.dentali.features.historial.domain.enums.SiNo;

public record SaludFemenina(
    SiNo estaEmbarazada,
    Integer mesesEmbarazo,
    SiNo estaLactando,
    SiNo tomaAnticonceptivos,
    String observaciones
) {
    
}
