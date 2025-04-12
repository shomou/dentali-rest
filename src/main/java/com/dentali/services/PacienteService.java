package com.dentali.services;

import java.util.List;
import java.util.Optional;

import com.dentali.dto.PacienteDTO;



public interface PacienteService {
	public List<PacienteDTO> obtenerTodos();

	public Optional<PacienteDTO> obtenerPorId(Long id);

	public List<PacienteDTO> buscarPorNombre(String nombre);

	public PacienteDTO guardar(PacienteDTO pacienteDTO);

	public Optional<PacienteDTO> eliminar(Long id);
	
	Optional<PacienteDTO> update(Long id, PacienteDTO pacienteDTO);
	
	
}
