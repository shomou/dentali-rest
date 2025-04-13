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

import com.dentali.dto.PacienteDTO;
import com.dentali.services.PacienteService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/PacienteDTOs")
@RequiredArgsConstructor
public class PacienteController {

	@Autowired
	private PacienteService service;
	
	// Listar Pacientes
	@GetMapping("/list")
	public List<PacienteDTO> listarPacienteDTOs(){
		return service.obtenerTodos();
	}
	
	// Crear Paciente
	@PostMapping
	public ResponseEntity<?> create (@RequestBody PacienteDTO PacienteDTO){
		// Validaciones 
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(PacienteDTO));
	}
	
	// Buscar Paciente por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id){
		Optional<PacienteDTO> PacienteDTOOptional = service.obtenerPorId(id);
		
		if (PacienteDTOOptional.isPresent()) {
			return ResponseEntity.ok(PacienteDTOOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	// Actualizar Paciente
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody PacienteDTO PacienteDTO, @PathVariable Long id){
		
		Optional<PacienteDTO> PacienteDTOOptional = service.update(id, PacienteDTO);
		
		if (PacienteDTOOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.CREATED).body(PacienteDTOOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	// Eliminar Paciente
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<PacienteDTO> PacienteDTOOptional =  service.eliminar(id);
		
		if(PacienteDTOOptional.isPresent()){
			return ResponseEntity.ok(PacienteDTOOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
}
