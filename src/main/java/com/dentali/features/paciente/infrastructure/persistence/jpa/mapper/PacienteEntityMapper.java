package com.dentali.features.paciente.infrastructure.persistence.jpa.mapper;

import com.dentali.features.paciente.domain.model.Paciente;
import com.dentali.features.paciente.infrastructure.persistence.jpa.PacienteEntity;
import org.springframework.stereotype.Component;

@Component
public class PacienteEntityMapper {
    public Paciente toDomain(PacienteEntity entity) {
        if (entity == null) return null;
        return Paciente.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .identificacion(entity.getIdentificacion())
                .fechaNacimiento(entity.getFechaNacimiento())
                .genero(entity.getGenero())
                .estado(entity.getEstado())
                .telefono(entity.getTelefono())
                .email(entity.getEmail())
                .direccion(entity.getDireccion())
                .fechaRegistro(entity.getFechaRegistro())
                .ultimaActualizacion(entity.getUltimaActualizacion())
                .build();
    }

    public PacienteEntity toEntity(Paciente domain) {
        if (domain == null) return null;
        return PacienteEntity.builder()
                .id(domain.getId())
                .nombre(domain.getNombre())
                .apellido(domain.getApellido())
                .identificacion(domain.getIdentificacion())
                .fechaNacimiento(domain.getFechaNacimiento())
                .genero(domain.getGenero())
                .estado(domain.getEstado())
                .telefono(domain.getTelefono())
                .email(domain.getEmail())
                .direccion(domain.getDireccion())                
                .build();
    }
}
