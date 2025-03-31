package com.dentali.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.dto.CitaDTO;
import com.dentali.services.CitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@GetMapping("/list")
	public List<CitaDTO> list (){
		
		return citaService.listar();
	}
	
	@GetMapping("/{id}")
	public Optional<CitaDTO> view(@PathVariable Long id){
		
		return citaService.obtenerCita(id);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CitaDTO citaDTO){
		return ResponseEntity.ok(citaService.guardar(citaDTO));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CitaDTO citaDTO){
		
		Optional<CitaDTO> citaOptional = citaService.actualizar(id, citaDTO);
		
		if(citaOptional.isPresent()) {
			return ResponseEntity.ok(citaOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/cancel/{id}")
	public ResponseEntity<?> cancel(@PathVariable Long id,@RequestBody CitaDTO citaDTO){
		
		Optional<CitaDTO> citaOptional = citaService.cancelar(id, citaDTO);
		
		if(citaOptional.isPresent()) {
			return ResponseEntity.ok(citaOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
