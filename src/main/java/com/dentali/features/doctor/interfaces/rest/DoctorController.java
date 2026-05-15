package com.dentali.features.doctor.interfaces.rest;

import java.util.List;

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
import jakarta.validation.Valid;

import com.dentali.features.doctor.application.dto.request.DoctorRegistrationRequest;
import com.dentali.features.doctor.application.dto.request.DoctorRequest;
import com.dentali.features.doctor.application.dto.response.DoctorResponse;
import com.dentali.features.doctor.application.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/odontologos")
@RequiredArgsConstructor
public class DoctorController {

	private final DoctorService doctorService;

	@GetMapping
	public ResponseEntity<List<DoctorResponse>> listarTodos() {
		return ResponseEntity.ok(doctorService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DoctorResponse> obtenerPorId(@PathVariable Long id) {
		DoctorResponse doctor = doctorService.buscarDoctorPorId(id);
		return ResponseEntity.ok(doctor);
	}

	@PostMapping
	public ResponseEntity<DoctorResponse> crear(@Valid @RequestBody DoctorRegistrationRequest request) {
		DoctorResponse nuevoDoctor = doctorService.crear(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDoctor);
	}

	@PutMapping("/{id}")
	public ResponseEntity<DoctorResponse> actualizar(@PathVariable Long id, @Valid @RequestBody DoctorRequest request) {
		return ResponseEntity.ok(doctorService.actualizar(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		doctorService.eliminar(id);
		return ResponseEntity.noContent().build();
	}

}
