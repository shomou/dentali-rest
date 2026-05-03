package com.dentali.features.historial.service;

import java.util.List;

import com.dentali.features.historial.dto.HistorialMedicoDTO;

public interface HistorialMedicoService {

	public List<HistorialMedicoDTO> listar();

	public HistorialMedicoDTO create(HistorialMedicoDTO historialDTO);

	public HistorialMedicoDTO buscarPacienteId(Long id);

	public HistorialMedicoDTO update(HistorialMedicoDTO historailDTO);

}
