package com.dentali.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dentali.dto.CitaDTO;
import com.dentali.entities.Cita;
import com.dentali.entities.Doctor;
import com.dentali.entities.Paciente;
import com.dentali.repositories.DoctorRepository;
import com.dentali.repositories.PacienteRepository;

@Component
public class CitaMapper {

	@Autowired
	PacienteRepository repositoryP;
	
	@Autowired
	DoctorRepository repositoryD;
	
	public CitaDTO toDTO(Cita cita) {
		return new CitaDTO(cita.getId(), cita.getPaciente().getId(), cita.getDoctor().getId(), cita.getMotivo(),
				cita.getEstado(), cita.getFecha());
	}

	public Cita toEntity(CitaDTO dto) {		
		
		Paciente paciente = repositoryP.findById(dto.getId_paciente()).orElseThrow(null);
		Doctor doctor = repositoryD.findById(dto.getId_odontologo()).orElseThrow(null);
		
		return new Cita(dto.getId(), doctor, paciente, dto.getEstado(), dto.getMotivo(), dto.getFecha());
	}
	
}
