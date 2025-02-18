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

import com.dentali.entities.Cita;
import com.dentali.services.CitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {
	
	@Autowired
	CitaService citaService;
	
	@GetMapping("/list")
	public List<Cita> list (){
		return citaService.listar();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cita cita){
		return ResponseEntity.ok(citaService.guardar(cita));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cita cita){
		
		Optional<Cita> citaOptional = citaService.actualizar(id, cita);
		
		if(citaOptional.isPresent()) {
			return ResponseEntity.ok(citaOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/cancel/{id}")
	public ResponseEntity<?> cancel(@PathVariable Long id,@RequestBody Cita cita){
		
		Optional<Cita> citaOptional = citaService.cancelar(id, cita);
		
		if(citaOptional.isPresent()) {
			return ResponseEntity.ok(citaOptional.orElseThrow());
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
