package com.dentali.features.doctor.infrastructure.jpa.mapper;

import org.springframework.stereotype.Component;

import com.dentali.features.doctor.domain.model.Doctor;
import com.dentali.features.doctor.infrastructure.jpa.DoctorEntity;

@Component
public class DoctorEntityMapper {

	public Doctor toDomain(DoctorEntity doctor) {
		if (doctor == null)
			return null;

		Doctor domain = new Doctor();
		domain.setId(doctor.getId());
		domain.setNombre(doctor.getNombre());
		domain.setApellido(doctor.getApellido());
		domain.setEspecialidad(doctor.getEspecialidad());
		domain.setTelefono(doctor.getTelefono());
		domain.setEmail(doctor.getEmail());
		// Convertimos LocalDateTime a LocalDate para el DTO
		if (doctor.getFechaRegistro() != null) {
			domain.setFechaRegistro(doctor.getFechaRegistro());
		}
		return domain;
	}

	public DoctorEntity toEntity(Doctor domain) {
		if (domain == null)
			return null;

		DoctorEntity doctor = new DoctorEntity();
		doctor.setId(domain.getId());
		doctor.setNombre(domain.getNombre());
		doctor.setApellido(domain.getApellido());
		doctor.setEspecialidad(domain.getEspecialidad());
		doctor.setTelefono(domain.getTelefono());
		doctor.setEmail(domain.getEmail());
		// Convertimos LocalDate a LocalDateTime para la entidad (atStartOfDay)
		if (domain.getFechaRegistro() != null) {
			doctor.setFechaRegistro(domain.getFechaRegistro());
		}
		return doctor;
	}

	

}
