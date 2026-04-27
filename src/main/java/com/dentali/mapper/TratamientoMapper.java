package com.dentali.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.dentali.dto.TratamientoDTO;
import com.dentali.entities.Tratamiento;
import com.dentali.repositories.CitaRepository;
import com.dentali.repositories.DoctorRepository;
import com.dentali.repositories.PacienteRepository;

import org.springframework.stereotype.Component;

@Component
public class TratamientoMapper {

    @Autowired
    private PacienteRepository repositoryP;

    @Autowired
    private DoctorRepository repositoryD;

    @Autowired
    private CitaRepository repositoryC;

    public TratamientoDTO toDTO(Tratamiento tratamiento) {
        TratamientoDTO tratamientoDTO = new TratamientoDTO();
        tratamientoDTO.setId(tratamiento.getId());
        tratamientoDTO.setId_paciente(tratamiento.getPaciente().getId());
        tratamientoDTO.setId_doctor(tratamiento.getDoctor().getId());
        tratamientoDTO.setId_cita(tratamiento.getCita().getId());
        tratamientoDTO.setDescripcion(tratamiento.getDescripcion());
        tratamientoDTO.setCosto(tratamiento.getCosto());
        tratamientoDTO.setFecha(tratamiento.getFecha());

        return tratamientoDTO;
    }

    public Tratamiento toEntity(TratamientoDTO tratamientoDTO) {
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(tratamientoDTO.getId());
        tratamiento.setPaciente(repositoryP.findById(tratamientoDTO.getId_paciente()).orElse(null));
        tratamiento.setDoctor(repositoryD.findById(tratamientoDTO.getId_doctor()).orElse(null));
        tratamiento.setCita(repositoryC.findById(tratamientoDTO.getId_cita()).orElse(null));
        tratamiento.setDescripcion(tratamientoDTO.getDescripcion());
        tratamiento.setCosto(tratamientoDTO.getCosto());
        tratamiento.setFecha(tratamientoDTO.getFecha());

        return tratamiento;
    }

}
