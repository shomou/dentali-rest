package com.dentali.features.paciente.mapper;

import org.springframework.stereotype.Component;


import com.dentali.features.paciente.domain.Paciente;
import com.dentali.features.paciente.dto.PacienteDTO;
import com.dentali.features.paciente.dto.PacienteUpdateDTO;
import com.dentali.features.paciente.dto.PacienteResponseDTO;

@Component
public class PacienteMapper {

    public PacienteDTO toDTO(Paciente paciente) {
        if (paciente == null) return null;

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        pacienteDTO.setGenero(paciente.getGenero());
        pacienteDTO.setEstadoCivil(paciente.getEstadoCivil());
        pacienteDTO.setOcupacion(paciente.getOcupacion());
        pacienteDTO.setReligion(paciente.getReligion());
        pacienteDTO.setNacionalidad(paciente.getNacionalidad());
        pacienteDTO.setTelefono(paciente.getTelefono());
        pacienteDTO.setEmail(paciente.getEmail());
        pacienteDTO.setDireccion(paciente.getDireccion());
        pacienteDTO.setEstado(paciente.getEstado());

        return pacienteDTO;
    }

    public Paciente toEntity(PacienteDTO pacienteDTO) {
        if (pacienteDTO == null) return null;

        Paciente paciente = new Paciente();
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setGenero(pacienteDTO.getGenero());
        paciente.setEstadoCivil(pacienteDTO.getEstadoCivil());
        paciente.setOcupacion(pacienteDTO.getOcupacion());
        paciente.setReligion(pacienteDTO.getReligion());
        paciente.setNacionalidad(pacienteDTO.getNacionalidad());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setEstado(pacienteDTO.getEstado());
        return paciente;
    }

    public Paciente toEntity(PacienteUpdateDTO dto) {
        if (dto == null) return null;

        Paciente paciente = new Paciente();
        paciente.setId(dto.getId());
        paciente.setNombre(dto.getNombre());
        paciente.setApellido(dto.getApellido());
        paciente.setFechaNacimiento(dto.getFechaNacimiento());
        paciente.setGenero(dto.getGenero());
        paciente.setEstadoCivil(dto.getEstadoCivil());
        paciente.setOcupacion(dto.getOcupacion());
        paciente.setReligion(dto.getReligion());
        paciente.setNacionalidad(dto.getNacionalidad());
        paciente.setTelefono(dto.getTelefono());
        paciente.setEmail(dto.getEmail());
        paciente.setDireccion(dto.getDireccion());
        paciente.setEstado(dto.getEstado());
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
                paciente.getGenero(),
                paciente.getEstadoCivil(),
                paciente.getOcupacion(),
                paciente.getReligion(),
                paciente.getNacionalidad(),
                paciente.getTelefono(),
                paciente.getEmail(),
                paciente.getDireccion(),
                paciente.getFechaRegistro(),
                paciente.getFechaActualizacion(),
                paciente.getEstado());
    }

}
