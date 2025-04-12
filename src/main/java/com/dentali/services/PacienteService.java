package com.dentali.services;

import java.util.List;
import java.util.Optional;

import com.dentali.dto.PacienteDTO;
<<<<<<< HEAD

=======
>>>>>>> e8cb7d106d05e0445759c6d6505f1b0ba0c57b1f


public interface PacienteService {
	public List<PacienteDTO> obtenerTodos();

	public Optional<PacienteDTO> obtenerPorId(Long id);

	public List<PacienteDTO> buscarPorNombre(String nombre);

	public PacienteDTO guardar(PacienteDTO pacienteDTO);

	public Optional<PacienteDTO> eliminar(Long id);
	
	Optional<PacienteDTO> update(Long id, PacienteDTO pacienteDTO);
	
	
}
