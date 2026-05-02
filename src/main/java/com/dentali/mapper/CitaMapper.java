package com.dentali.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dentali.dto.Cita.CitaDTO;
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
		return new CitaDTO(cita.getId(),
				cita.getPaciente() != null ? cita.getPaciente().getId() : null,
				cita.getDoctor() != null ? cita.getDoctor().getId() : null,
				cita.getMotivo(),
				cita.getEstado(),
				cita.getFecha());
	}

	public Cita toEntity(CitaDTO dto) {

		Paciente paciente = dto.getIdPaciente() != null ? repositoryP.findById(dto.getIdPaciente()).orElse(null) : null;

		Doctor doctor = dto.getIdOdontologo() != null ? repositoryD.findById(dto.getIdOdontologo()).orElse(null) : null;

		return new Cita(dto.getId(), doctor, paciente, dto.getEstado(), dto.getMotivo(), dto.getFecha());
	}

}
