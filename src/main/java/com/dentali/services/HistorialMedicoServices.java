package com.dentali.services;

import java.util.List;

import com.dentali.dto.Historial.HistorialMedicoDTO;

public interface HistorialMedicoServices {

	public List<HistorialMedicoDTO> listar();

	public HistorialMedicoDTO create(HistorialMedicoDTO historialDTO);

	public HistorialMedicoDTO buscarPacienteId(Long id);

	public HistorialMedicoDTO update(HistorialMedicoDTO historailDTO);

}
