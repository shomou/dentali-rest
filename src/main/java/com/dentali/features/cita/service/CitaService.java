package com.dentali.features.cita.service;

import java.util.List;
import java.util.Optional;

import com.dentali.features.cita.dto.CitaDTO;

public interface CitaService {

	public List<CitaDTO> listar();

	public Optional<CitaDTO> obtenerCita(Long id);

	public CitaDTO guardar(CitaDTO citaDTO);

	public Optional<CitaDTO> actualizar(Long id, CitaDTO citaDTO);

	public Optional<CitaDTO> cancelar(Long id, CitaDTO citaDTO);

}
