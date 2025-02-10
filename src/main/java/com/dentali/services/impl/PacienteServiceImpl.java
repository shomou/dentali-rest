package com.dentali.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.entities.Paciente;
import com.dentali.repositories.PacienteRepository;
import com.dentali.services.PacienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService{
    
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	@Transactional( readOnly = true )
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

	@Override
	@Transactional( readOnly = true )
    public Optional<Paciente> obtenerPorId(Long id) {
        return pacienteRepository.findById(id);
    }

	@Override
	@Transactional( readOnly = true )
    public List<Paciente> buscarPorNombre(String nombre) {
        return pacienteRepository.findByNombreContainingIgnoreCase(nombre);
    }

	@Override
	@Transactional
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

	@Override
	@Transactional
    public Optional<Paciente> eliminar(Long id) {
        Optional<Paciente> pacienteOptional =  pacienteRepository.findById(id);
        
        pacienteOptional.ifPresent(pacienteDB ->{
        	pacienteRepository.delete(pacienteDB);
        });
        
        return pacienteOptional;
    }

	@Override
	@Transactional
	public Optional<Paciente> update(Long id, Paciente paciente) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
		
		if (pacienteOptional.isPresent()) {
			Paciente pacienteDB = pacienteOptional.orElseThrow();
			pacienteDB.setApellido(paciente.getApellido());
			pacienteDB.setDireccion(paciente.getDireccion());
			pacienteDB.setEmail(paciente.getEmail());
			pacienteDB.setFechaNacimiento(paciente.getFechaNacimiento());
			pacienteDB.setNombre(paciente.getNombre());
			pacienteDB.setTelefono(paciente.getTelefono());
			
			return Optional.of(pacienteRepository.save(pacienteDB));
		}
		
		return pacienteOptional;
	}
	
	
}
