package com.dentali.services;

import java.util.List;

import com.dentali.entities.Cita;

public interface CitaService {
	
	public List<Cita> listar();
	
	public Cita guardar (Cita cita);
	
	
	
}
