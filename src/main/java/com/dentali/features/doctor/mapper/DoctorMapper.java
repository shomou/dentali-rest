package com.dentali.features.doctor.mapper;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.doctor.dto.DoctorDTO;
import com.dentali.features.doctor.dto.DoctorResponseDTO;

@Component
public class DoctorMapper {

	public DoctorDTO toDTO(Doctor doctor) {
		if (doctor == null)
			return null;

		DoctorDTO dto = new DoctorDTO();
		dto.setId(doctor.getId());
		dto.setNombre(doctor.getNombre());
		dto.setApellido(doctor.getApellido());
		dto.setEspecialidad(doctor.getEspecialidad());
		dto.setTelefono(doctor.getTelefono());
		dto.setEmail(doctor.getEmail());
		// Convertimos LocalDateTime a LocalDate para el DTO
		if (doctor.getFechaRegistro() != null) {
			dto.setFechaRegistro(doctor.getFechaRegistro().toLocalDate());
		}
		return dto;
	}

	public Doctor toEntity(DoctorDTO dto) {
		if (dto == null)
			return null;

		Doctor doctor = new Doctor();
		doctor.setId(dto.getId());
		doctor.setNombre(dto.getNombre());
		doctor.setApellido(dto.getApellido());
		doctor.setEspecialidad(dto.getEspecialidad());
		doctor.setTelefono(dto.getTelefono());
		doctor.setEmail(dto.getEmail());
		// Convertimos LocalDate a LocalDateTime para la entidad (atStartOfDay)
		if (dto.getFechaRegistro() != null) {
			doctor.setFechaRegistro(dto.getFechaRegistro().atStartOfDay());
		}
		return doctor;
	}

	/**
	 * Versión estándar que devuelve una lista vacía de roles.
	 * Útil para mappers de otras entidades (Cita, Historial, etc.)
	 */
	public DoctorResponseDTO toResponseDTO(Doctor doctor) {
		return toResponseDTO(doctor, Collections.emptyList());
	}

	/**
	 * Versión enriquecida con roles inyectados externamente.
	 * Usada por DoctorServiceImpl para mostrar el vínculo lógico con User.
	 */
	public DoctorResponseDTO toResponseDTO(Doctor doctor, List<String> roles) {
		if (doctor == null)
			return null;

		return new DoctorResponseDTO(
				doctor.getId(),
				doctor.getNombre(),
				doctor.getApellido(),
				doctor.getEspecialidad(),
				doctor.getTelefono(),
				doctor.getEmail(),
				doctor.getFechaRegistro(),
				roles != null ? roles : Collections.emptyList());
	}

}
