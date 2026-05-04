package com.dentali.features.doctor.service;

import java.util.List;
import java.util.Optional;

import com.dentali.features.doctor.dto.DoctorDTO;
import com.dentali.features.doctor.dto.DoctorResponseDTO;

public interface DoctorService {
	public List<DoctorResponseDTO> obtenerTodos();

	public Optional<DoctorResponseDTO> obtenerPorId(Long id);

	public List<DoctorResponseDTO> buscarPorEspecialidad(String especialidad);

	public DoctorResponseDTO guardar(DoctorDTO doctorDTO);

	public Optional<DoctorResponseDTO> eliminar(Long id);

	Optional<DoctorResponseDTO> update(Long id, DoctorDTO doctorDTO);
}
