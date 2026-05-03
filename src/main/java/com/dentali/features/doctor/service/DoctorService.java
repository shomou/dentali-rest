package com.dentali.features.doctor.service;

import java.util.List;
import java.util.Optional;

import com.dentali.features.doctor.dto.DoctorDTO;

public interface DoctorService {
	public List<DoctorDTO> obtenerTodos();

	public Optional<DoctorDTO> obtenerPorId(Long id);

	public List<DoctorDTO> buscarPorEspecialidad(String especialidad);

	public DoctorDTO guardar(DoctorDTO doctorDTO);

	public Optional<DoctorDTO> eliminar(Long id);

	Optional<DoctorDTO> update(Long id, DoctorDTO doctorDTO);
}
