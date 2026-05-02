package com.dentali.controllers;

import java.util.List;
import java.util.Optional;

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

import com.dentali.dto.Tratamiento.TratamientoDTO;
import com.dentali.services.TratamientoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tratamientos")
@RequiredArgsConstructor
public class TratamientoController {

	private final TratamientoService tratamientoService;

	// listar
	@GetMapping("/list")
	public List<TratamientoDTO> list() {
		return tratamientoService.obtenerTodos();
	}

	// create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TratamientoDTO tratamiento) {

		return ResponseEntity.ok(tratamientoService.guardar(tratamiento));
	}

	// buscar por paciente
	@GetMapping("/paciente/{id}")
	public ResponseEntity<?> viewPaciente(@PathVariable Long id) {

		List<TratamientoDTO> tratamientoPaciente = tratamientoService.buscarPorPaciente(id);

		if (!tratamientoPaciente.isEmpty()) {
			return ResponseEntity.ok(tratamientoPaciente);
		}

		return ResponseEntity.notFound().build();
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody TratamientoDTO tratamiento, @PathVariable Long id) {

		Optional<TratamientoDTO> tratamientoOptional = tratamientoService.actualizar(id, tratamiento);

		if (tratamientoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(tratamientoOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Optional<TratamientoDTO> tratamientoOptional = tratamientoService.eliminar(id);

		if (tratamientoOptional.isPresent()) {
			return ResponseEntity.ok(tratamientoOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
}
