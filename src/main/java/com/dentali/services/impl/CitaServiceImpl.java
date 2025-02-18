package com.dentali.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.Enum.EstadoCita;
import com.dentali.entities.Cita;
import com.dentali.repositories.CitaRepository;
import com.dentali.services.CitaService;

@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
    private CitaRepository citaRepository;
	
	// Listar Citas
	@Override
	@Transactional( readOnly = true )
	public List<Cita> listar() {
        return citaRepository.findAll();
    }

	// Guardar Cita
	@Override
	@Transactional
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }
	
	// Actualizar Cita
	@Override
	@Transactional
	public Optional<Cita> actualizar(Long id, Cita cita) {
		
		Optional<Cita> citaOptional = citaRepository.findById(id);
		
		if(citaOptional.isPresent()) {
			Cita citaDB = citaOptional.orElseThrow();
			citaDB.setDoctor(cita.getDoctor());
			citaDB.setMotivo(cita.getMotivo());
			
			return Optional.of(citaRepository.save(citaDB));
		}
		return citaOptional;
		
	}
	
	// Cancelar Cita
	@Override
	@Transactional
	public Optional<Cita> cancelar(Long id, Cita cita) {
		
		Optional<Cita> citaOptional = citaRepository.findById(id);
	
		EstadoCita estado =EstadoCita.CANCELADA;
		
		if(citaOptional.isPresent()) {
			Cita citaDB = citaOptional.orElseThrow();
			citaDB.setDoctor(cita.getDoctor());
			citaDB.setEstado(estado);
			citaDB.setMotivo(cita.getMotivo());
			
			return Optional.of(citaRepository.save(citaDB));
		}
		
		return citaOptional;
	}

		
}
