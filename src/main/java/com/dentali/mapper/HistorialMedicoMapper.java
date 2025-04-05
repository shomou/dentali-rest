package com.dentali.mapper;

import org.springframework.stereotype.Component;

import com.dentali.dto.HistorialMedicoDTO;
import com.dentali.entities.HistorialMedico;

@Component
public class HistorialMedicoMapper {

    public HistorialMedicoDTO toDTO(HistorialMedico historialMedico) {
        return new HistorialMedicoDTO(historialMedico.getId(), historialMedico.getPaciente().getId(),
                historialMedico.getDoctor().getId(), historialMedico.getAntecedentes(), historialMedico.getAlergias(),
                historialMedico.getMedicamentosActuales(), historialMedico.getEnfermedadesCronicas(),
                historialMedico.getFechaActualizacion());
    }

    public HistorialMedico toEntity(HistorialMedicoDTO dto) {
        return null;
    }
}
