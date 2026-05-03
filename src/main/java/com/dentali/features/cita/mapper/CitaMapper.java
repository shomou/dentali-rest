package com.dentali.features.cita.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dentali.features.cita.domain.Cita;
import com.dentali.features.cita.dto.CitaDTO;
import com.dentali.features.cita.dto.CitaResponseDTO;
import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.doctor.mapper.DoctorMapper;
import com.dentali.features.doctor.repository.DoctorRepository;
import com.dentali.features.paciente.domain.Paciente;
import com.dentali.features.paciente.mapper.PacienteMapper;
import com.dentali.features.paciente.repository.PacienteRepository;

@Component
public class CitaMapper {

	@Autowired
	PacienteRepository repositoryP;

	@Autowired
	DoctorRepository repositoryD;

	@Autowired
	PacienteMapper pacienteMapper;

	@Autowired
	DoctorMapper doctorMapper;

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

	public CitaResponseDTO toResponseDTO(Cita cita) {
		if (cita == null)
			return null;
		return new CitaResponseDTO(
				cita.getId(),
				pacienteMapper.toResponseDTO(cita.getPaciente()),
				doctorMapper.toResponseDTO(cita.getDoctor()),
				cita.getMotivo(),
				cita.getEstado(),
				cita.getFecha(),
				cita.getFechaCreacion());
	}

}
