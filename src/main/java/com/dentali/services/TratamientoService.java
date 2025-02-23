package com.dentali.services;

import java.util.List;
import java.util.Optional;

import com.dentali.entities.Tratamiento;

public interface TratamientoService {

	public List<Tratamiento> obtenerTodos();
	
	public Tratamiento guardar(Tratamiento tratamiento);
	
	public List<Tratamiento> buscarPorPaciente(Long id);
	
	public Optional<Tratamiento> eliminar (Long id);
	
	Optional<Tratamiento> update(Long id, Tratamiento tratamiento);
	
}

