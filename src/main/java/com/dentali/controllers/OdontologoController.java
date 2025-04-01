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

import com.dentali.dto.DoctorDTO;
import com.dentali.services.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/odontologos")
@RequiredArgsConstructor
public class OdontologoController {		
	
	@Autowired
	private DoctorService doctorService;
	
	// Listar Doctores
	@GetMapping("/list")
	public List<DoctorDTO> listarDoctores(){
		return doctorService.obtenerTodos();
	}
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody DoctorDTO doctorDTO){
		// Validaciones
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.guardar(doctorDTO));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id){
		Optional<DoctorDTO>  doctorOptional = doctorService.obtenerPorId(id);
		
		if(doctorOptional.isPresent()){
			return ResponseEntity.ok(doctorOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody DoctorDTO doctorDTO, @PathVariable Long id){
		Optional<DoctorDTO> doctorOptional = doctorService.update(id, doctorDTO);
		
		if(doctorOptional.isPresent()){
			return ResponseEntity.ok(doctorOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<DoctorDTO> doctorOptional = doctorService.eliminar(id);
		
		if(doctorOptional.isPresent()) {
			return ResponseEntity.ok(doctorOptional.orElseThrow());
		}
		return ResponseEntity.notFound().build();
	}
	
}
