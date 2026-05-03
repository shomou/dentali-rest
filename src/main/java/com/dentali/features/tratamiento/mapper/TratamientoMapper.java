package com.dentali.features.tratamiento.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.dentali.features.cita.repository.CitaRepository;
import com.dentali.features.doctor.mapper.DoctorMapper;
import com.dentali.features.doctor.repository.DoctorRepository;
import com.dentali.features.paciente.mapper.PacienteMapper;
import com.dentali.features.paciente.repository.PacienteRepository;
import com.dentali.features.tratamiento.domain.Tratamiento;
import com.dentali.features.tratamiento.dto.TratamientoDTO;
import com.dentali.features.tratamiento.dto.TratamientoResponseDTO;

import org.springframework.stereotype.Component;

@Component
public class TratamientoMapper {

    @Autowired
    private PacienteRepository repositoryP;

    @Autowired
    private DoctorRepository repositoryD;

    @Autowired
    private CitaRepository repositoryC;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    public TratamientoDTO toDTO(Tratamiento tratamiento) {
        TratamientoDTO tratamientoDTO = new TratamientoDTO();
        tratamientoDTO.setId(tratamiento.getId());
        tratamientoDTO.setIdPaciente(tratamiento.getPaciente() != null ? tratamiento.getPaciente().getId() : null);
        tratamientoDTO.setIdDoctor(tratamiento.getDoctor() != null ? tratamiento.getDoctor().getId() : null);
        tratamientoDTO.setIdCita(tratamiento.getCita() != null ? tratamiento.getCita().getId() : null);
        tratamientoDTO.setDescripcion(tratamiento.getDescripcion());
        tratamientoDTO.setCosto(tratamiento.getCosto());
        tratamientoDTO.setFecha(tratamiento.getFecha());

        return tratamientoDTO;
    }

    public Tratamiento toEntity(TratamientoDTO tratamientoDTO) {
        Tratamiento tratamiento = new Tratamiento();
        tratamiento.setId(tratamientoDTO.getId());

        tratamiento.setPaciente(tratamientoDTO.getIdPaciente() != null
                ? repositoryP.findById(tratamientoDTO.getIdPaciente()).orElse(null)
                : null);

        tratamiento.setDoctor(
                tratamientoDTO.getIdDoctor() != null ? repositoryD.findById(tratamientoDTO.getIdDoctor()).orElse(null)
                        : null);

        tratamiento.setCita(
                tratamientoDTO.getIdCita() != null ? repositoryC.findById(tratamientoDTO.getIdCita()).orElse(null)
                        : null);

        tratamiento.setDescripcion(tratamientoDTO.getDescripcion());
        tratamiento.setCosto(tratamientoDTO.getCosto());
        tratamiento.setFecha(tratamientoDTO.getFecha());

        return tratamiento;
    }

    public TratamientoResponseDTO toResponseDTO(Tratamiento tratamiento) {
        if (tratamiento == null)
            return null;
        return new TratamientoResponseDTO(
                tratamiento.getId(),
                pacienteMapper.toResponseDTO(tratamiento.getPaciente()),
                doctorMapper.toResponseDTO(tratamiento.getDoctor()),
                tratamiento.getDescripcion(),
                tratamiento.getCosto(),
                tratamiento.getFecha());
    }

}
