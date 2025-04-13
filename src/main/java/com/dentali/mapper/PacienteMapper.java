package com.dentali.mapper;

import org.springframework.stereotype.Component;

import com.dentali.dto.PacienteDTO;
import com.dentali.entities.Paciente;

@Component
public class PacienteMapper {


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

}
