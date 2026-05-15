package com.dentali.features.paciente.application.mapper;

import org.springframework.stereotype.Component;

import com.dentali.features.paciente.application.dto.request.PacienteRequest;
import com.dentali.features.paciente.application.dto.response.PacienteResponse;
import com.dentali.features.paciente.domain.enums.EstadoPaciente;
import com.dentali.features.paciente.domain.model.Paciente;

@Component
public class PacienteDtoMapper {

    public Paciente toDomain(PacienteRequest request) {
        if (request == null)
            return null;

        return Paciente.builder()
                .nombre(request.nombre())
                .apellido(request.apellido())
                .identificacion(request.identificacion())
                .fechaNacimiento(request.fechaNacimiento())
                .genero(request.genero())
                .telefono(request.telefono())
                .email(request.email())
                .direccion(request.direccion())
                .estado(EstadoPaciente.ACTIVO)
                .build();
    }

    public PacienteResponse toResponse(Paciente domain) {
        if (domain == null)
            return null;
        return new PacienteResponse(
                domain.getId(),
                domain.getNombreCompleto(), // Usamos la lógica de dominio que ya programaste
                domain.getIdentificacion(),
                domain.getEdad(), // Usamos el cálculo dinámico
                domain.getGenero(),
                domain.getEstado(),
                domain.getTelefono(),
                domain.getEmail(),
                domain.getDireccion());
    }
}
