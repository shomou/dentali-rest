package com.dentali.mapper;

import org.springframework.stereotype.Component;

import com.dentali.dto.PacienteDTO;
import com.dentali.entities.Paciente;

@Component
public class PacienteMapper {

<<<<<<< HEAD
    public PacienteDTO toDTO (Paciente paciente){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId (paciente.getId());
		pacienteDTO.setNombre(paciente.getNombre());
		pacienteDTO.setApellido(paciente.getApellido());
		pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
		pacienteDTO.setTelefono(paciente.getTelefono());
		pacienteDTO.setEmail(paciente.getEmail());
		pacienteDTO.setDireccion(paciente.getDireccion());
		pacienteDTO.setFechaRegistro(paciente.getFechaRegistro());

        return pacienteDTO;
    }

    public Paciente toEntity (PacienteDTO pacienteDTO){
        Paciente paciente = new Paciente();
        paciente.setId (pacienteDTO.getId());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setFechaRegistro(pacienteDTO.getFechaRegistro());                    
        return paciente;
    }
=======
    // Convierte un PacienteDTO a Paciente

    public Paciente toEntity(PacienteDTO pacienteDTO) {
        if (pacienteDTO == null) {
            return null;
        }

        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());

        return paciente;
    }
    
    // Convierte un Paciente a PacienteDTO
    public PacienteDTO toDto(Paciente paciente) {
        if (paciente == null) {
            return null;
        }

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        pacienteDTO.setDireccion(paciente.getDireccion());
        pacienteDTO.setEmail(paciente.getEmail());
        pacienteDTO.setTelefono(paciente.getTelefono());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());

        return pacienteDTO;
    }
>>>>>>> e8cb7d106d05e0445759c6d6505f1b0ba0c57b1f
}
