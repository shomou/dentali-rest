package com.dentali.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.entities.Paciente;
import com.dentali.services.PacienteService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

	@Autowired
	private PacienteService service;
	
	// Listar Pacientes
	@GetMapping("/list")
	public List<Paciente> listarPacientes(){
		return service.obtenerTodos();
	}
	
	// Crear Paciente
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Paciente paciente){
		// Validaciones 
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(paciente));
	}
	
	// Buscar Paciente por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id){
		Optional<Paciente> pacienteOptional = service.obtenerPorId(id);
		
		if (pacienteOptional.isPresent()) {
			return ResponseEntity.ok(pacienteOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	// Actualizar Paciente
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Paciente paciente, @PathVariable Long id){
		
		Optional<Paciente> pacienteOptional = service.update(id, paciente);
		
		if (pacienteOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.CREATED).body(pacienteOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	// Eliminar Paciente
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Paciente> pacienteOptional =  service.eliminar(id);
		
		if(pacienteOptional.isPresent()){
			return ResponseEntity.ok(pacienteOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
