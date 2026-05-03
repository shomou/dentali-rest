package com.dentali.features.historial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.features.historial.dto.HistorialMedicoDTO;
import com.dentali.features.historial.service.HistorialMedicoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/historial")
@RequiredArgsConstructor
public class HistorialMedicoController {

	private final HistorialMedicoService historialService;

	@GetMapping("/list")
	public List<HistorialMedicoDTO> list() {
		return historialService.listar();
	}

	@PostMapping
	public ResponseEntity<HistorialMedicoDTO> create(@RequestBody HistorialMedicoDTO historial) {
		HistorialMedicoDTO nuevoHistorial = historialService.create(historial);
		return new ResponseEntity<>(nuevoHistorial, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HistorialMedicoDTO> buscarporId(@PathVariable Long id) {
		HistorialMedicoDTO historial = historialService.buscarPacienteId(id);

		if (historial == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(historial, HttpStatus.OK);
		}

	}

	@PutMapping
	public ResponseEntity<HistorialMedicoDTO> actualizar(@RequestBody HistorialMedicoDTO historialDTO) {
		HistorialMedicoDTO historial = historialService.update(historialDTO);
		return new ResponseEntity<>(historial, HttpStatus.CREATED);
	}

}
