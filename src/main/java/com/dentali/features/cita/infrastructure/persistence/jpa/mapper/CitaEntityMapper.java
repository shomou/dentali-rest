package com.dentali.features.cita.infrastructure.persistence.jpa.mapper;

import org.springframework.stereotype.Component;
import com.dentali.features.cita.domain.model.Cita;
import com.dentali.features.cita.infrastructure.persistence.jpa.CitaEntity;
import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.paciente.domain.model.Paciente;

@Component
public class CitaEntityMapper {

    public CitaEntity toEntity(Cita domain) {
        if (domain == null) return null;
        
        return CitaEntity.builder()
                .id(domain.getId())
                .fechaHora(domain.getFechaHora())
                .motivo(domain.getMotivo())
                .estado(domain.getEstado())
                .observaciones(domain.getObservaciones())
                .pacienteId(domain.getPaciente() != null ? domain.getPaciente().getId() : null)
                .doctorId(domain.getDoctor() != null ? domain.getDoctor().getId() : null)
                .build();
    }

    public Cita toDomain(CitaEntity entity) {
        if (entity == null) return null;

        return Cita.builder()
                .id(entity.getId())
                .fechaHora(entity.getFechaHora())
                .motivo(entity.getMotivo())
                .estado(entity.getEstado())
                .observaciones(entity.getObservaciones())
                // Creamos objetos "shell" con el ID para cumplir con el contrato del dominio
                .paciente(entity.getPacienteId() != null ? Paciente.builder().id(entity.getPacienteId()).build() : null)
                .doctor(entity.getDoctorId() != null ? Doctor.builder().id(entity.getDoctorId()).build() : null)
                .build();
    }
}