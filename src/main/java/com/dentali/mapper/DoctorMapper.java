package com.dentali.mapper;

import org.springframework.stereotype.Component;

import com.dentali.dto.Doctor.DoctorDTO;
import com.dentali.entities.Doctor;

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

}
