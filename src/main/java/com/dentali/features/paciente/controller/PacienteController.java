package com.dentali.features.paciente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.features.paciente.dto.PacienteDTO;
import com.dentali.features.paciente.service.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

	private final PacienteService service;

	// Listar Pacientes
	@GetMapping("/list")
	public List<PacienteDTO> listarPacienteDTOs() {
		return service.obtenerTodos();
	}

	// Crear Paciente
	@PostMapping
	public ResponseEntity<?> create(@RequestBody PacienteDTO pacienteDTO) {
		// Validaciones
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(pacienteDTO));
	}

	// Buscar Paciente por ID
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id) {
		Optional<PacienteDTO> PacienteDTOOptional = service.obtenerPorId(id);

		if (PacienteDTOOptional.isPresent()) {
			return ResponseEntity.ok(PacienteDTOOptional.orElseThrow());
		}

		return ResponseEntity.notFound().build();
	}

	// Actualizar Paciente
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody PacienteDTO pacienteDTO, @PathVariable Long id) {

		Optional<PacienteDTO> pacienteDTOOptional = service.update(id, pacienteDTO);

		if (pacienteDTOOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDTOOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	// Eliminar Paciente
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<PacienteDTO> pacienteDTOOptional = service.eliminar(id);

		if (pacienteDTOOptional.isPresent()) {
			return ResponseEntity.ok(pacienteDTOOptional.orElseThrow());
		}

		return ResponseEntity.notFound().build();
	}

}
