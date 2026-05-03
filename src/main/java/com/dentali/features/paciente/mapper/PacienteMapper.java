package com.dentali.features.paciente.mapper;

import org.springframework.stereotype.Component;

import com.dentali.features.paciente.domain.Paciente;
import com.dentali.features.paciente.dto.PacienteDTO;
import com.dentali.features.paciente.dto.PacienteResponseDTO;

@Component
public class PacienteMapper {

    public PacienteDTO toDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        pacienteDTO.setTelefono(paciente.getTelefono());
        pacienteDTO.setEmail(paciente.getEmail());
        pacienteDTO.setDireccion(paciente.getDireccion());
        pacienteDTO.setFechaRegistro(paciente.getFechaRegistro());

        return pacienteDTO;
    }

    public Paciente toEntity(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setFechaRegistro(pacienteDTO.getFechaRegistro());
        return paciente;
    }

    public PacienteResponseDTO toResponseDTO(Paciente paciente) {
        if (paciente == null)
            return null;
        return new PacienteResponseDTO(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getFechaNacimiento(),
                paciente.getTelefono(),
                paciente.getEmail(),
                paciente.getDireccion(),
                paciente.getFechaRegistro());
    }

}
