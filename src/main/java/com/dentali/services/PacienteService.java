package com.dentali.services;

import java.util.List;
import java.util.Optional;

import com.dentali.entities.Paciente;

public interface PacienteService {
	public List<Paciente> obtenerTodos();

	public Optional<Paciente> obtenerPorId(Long id);

	public List<Paciente> buscarPorNombre(String nombre);

	public Paciente guardar(Paciente paciente);

	public Optional<Paciente> eliminar(Long id);
	
	Optional<Paciente> update(Long id, Paciente paciente);
}
