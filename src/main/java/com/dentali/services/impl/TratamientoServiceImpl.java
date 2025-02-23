package com.dentali.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.entities.Tratamiento;
import com.dentali.repositories.TratamientoRepository;
import com.dentali.services.TratamientoService;

@Service
public class TratamientoServiceImpl implements TratamientoService{

	@Autowired
	TratamientoRepository tratamientoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tratamiento> obtenerTodos() {
		
		return tratamientoRepository.findAll();
	}

	@Override
	@Transactional
	public Tratamiento guardar(Tratamiento tratamiento) {
		
		return tratamientoRepository.save(tratamiento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tratamiento> buscarPorPaciente(Long id) {
		
		return tratamientoRepository.findByPacienteId(id);
	}

	@Override
	@Transactional
	public Optional<Tratamiento> eliminar(Long id) {
		
		Optional<Tratamiento> tratamientoOptional = tratamientoRepository.findById(id);
		
		tratamientoOptional.ifPresent( tratamientoDb -> {
			tratamientoRepository.delete(tratamientoDb);
		});
		
		return tratamientoOptional;
	}

	@Override
	@Transactional
	public Optional<Tratamiento> update(Long id, Tratamiento tratamiento) {
		Optional<Tratamiento> tratamientoOptional = tratamientoRepository.findById(id);
		
		if (tratamientoOptional.isPresent()) {
			Tratamiento tratamientoDb = tratamientoOptional.orElseThrow();
			tratamientoDb.setCosto(tratamiento.getCosto());
			tratamientoDb.setDescripcion(tratamiento.getDescripcion());
			
			return Optional.of(tratamientoRepository.save(tratamientoDb));
		}
		
		return tratamientoOptional;
	}

}
