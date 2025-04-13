package com.dentali.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dentali.dto.HistorialMedicoDTO;
import com.dentali.entities.HistorialMedico;
import com.dentali.repositories.DoctorRepository;
import com.dentali.repositories.PacienteRepository;

@Component
public class HistorialMedicoMapper {

    @Autowired
    private PacienteRepository repositoryP;

    @Autowired
    private DoctorRepository repositoryD;

    public HistorialMedicoDTO toDTO(HistorialMedico historialMedico) {
        return new HistorialMedicoDTO(historialMedico.getId(), 
        historialMedico.getPaciente().getId(),
                historialMedico.getDoctor().getId(), 
                historialMedico.getAntecedentes(), 
                historialMedico.getAlergias(),
                historialMedico.getMedicamentosActuales(), 
                historialMedico.getEnfermedadesCronicas(),
                historialMedico.getFechaActualizacion());
    }

    public HistorialMedico toEntity(HistorialMedicoDTO dto) {
        return new HistorialMedico(
            dto.getId(),
            repositoryP.findById(dto.getPaciente_id()).orElse(null), // Busca el paciente por ID
            repositoryD.findById(dto.getDoctor_id()).orElse(null),  // Busca el doctor por ID
            dto.getAntecedentes(),
            dto.getAlergias(),
            dto.getMedicamentosActuales(),
            dto.getEnfermedadesCronicas()
        );
    }
}
