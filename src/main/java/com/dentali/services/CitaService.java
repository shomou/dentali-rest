package com.dentali.services;

import java.util.List;
import java.util.Optional;

import com.dentali.entities.Cita;

public interface CitaService {
	
	public List<Cita> listar();
	
	public Cita guardar (Cita cita);
	
	public Optional<Cita> cancelar(Long id, Cita cita);
	
}
