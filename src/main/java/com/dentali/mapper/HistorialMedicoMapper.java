package com.dentali.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dentali.dto.Historial.HistorialMedicoDTO;
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
                historialMedico.getPaciente() != null ? historialMedico.getPaciente().getId() : null,
                historialMedico.getDoctor() != null ? historialMedico.getDoctor().getId() : null,
                historialMedico.getAntecedentes(),
                historialMedico.getAlergias(),
                historialMedico.getMedicamentosActuales(),
                historialMedico.getEnfermedadesCronicas(),
                historialMedico.getFechaActualizacion());
    }

    public HistorialMedico toEntity(HistorialMedicoDTO dto) {
        return new HistorialMedico(
                dto.getId(),
                dto.getIdPaciente() != null ? repositoryP.findById(dto.getIdPaciente()).orElse(null) : null,
                dto.getIdDoctor() != null ? repositoryD.findById(dto.getIdDoctor()).orElse(null) : null,
                dto.getAntecedentes(),
                dto.getAlergias(),
                dto.getMedicamentosActuales(),
                dto.getEnfermedadesCronicas());
    }
}
