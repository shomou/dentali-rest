package com.dentali.features.doctor.mapper;

import org.springframework.stereotype.Component;

import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.doctor.dto.DoctorDTO;
import com.dentali.features.doctor.dto.DoctorResponseDTO;

@Component
public class DoctorMapper {

	public DoctorDTO toDTO(Doctor doctor) {
		return new DoctorDTO(doctor.getId(), doctor.getNombre(), doctor.getApellido(), doctor.getEspecialidad(),
				doctor.getTelefono(), doctor.getEmail());
	}

	public Doctor toEntity(DoctorDTO dto) {

		return new Doctor(dto.getId(), dto.getNombre(), dto.getApellido(), dto.getEspecialidad(), dto.getTelefono(),
				dto.getEmail());

	}

	public DoctorResponseDTO toResponseDTO(Doctor doctor) {
		if (doctor == null)
			return null;
		return new DoctorResponseDTO(
				doctor.getId(),
				doctor.getNombre(),
				doctor.getApellido(),
				doctor.getEspecialidad(),
				doctor.getTelefono(),
				doctor.getEmail(),
				doctor.getFechaRegistro());
	}

}
