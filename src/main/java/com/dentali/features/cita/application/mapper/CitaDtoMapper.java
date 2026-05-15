package com.dentali.features.cita.application.mapper;

import org.springframework.stereotype.Component;
import com.dentali.features.cita.application.dto.request.CitaRequest;
import com.dentali.features.cita.application.dto.response.CitaResponse;
import com.dentali.features.cita.domain.enums.EstadoCita;
import com.dentali.features.cita.domain.model.Cita;
import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.paciente.domain.model.Paciente;

@Component
public class CitaDtoMapper {

    public Cita toDomain(CitaRequest request, Paciente paciente, Doctor doctor) {
        if (request == null) {
            return null;
        }

        return Cita.builder()
                .fechaHora(request.fecha_hora())
                .motivo(request.motivo())
                .observaciones(request.observaciones())
                .estado(EstadoCita.PROGRAMADA) // Estado inicial por defecto
                .paciente(paciente)
                .doctor(doctor)
                .build();
    }

    public CitaResponse toResponse(Cita domain) {
        if (domain == null) {
            return null;
        }

        return new CitaResponse(
                domain.getId(),
                domain.getPaciente().getNombreCompleto(),
                domain.getDoctor().getNombre() + " " + domain.getDoctor().getApellido(),
                domain.getFechaHora().toString(), // Convertir LocalDateTime a String
                domain.getMotivo(),
                domain.getEstado().name(),
                domain.getObservaciones()
        );
    }
}