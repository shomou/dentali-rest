package com.dentali.features.cita.interfaces.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dentali.features.cita.application.dto.request.CitaRequest;
import com.dentali.features.cita.application.dto.response.CitaResponse;
import com.dentali.features.cita.application.service.CitaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @PostMapping
    public ResponseEntity<CitaResponse> crear(@Valid @RequestBody CitaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(citaService.createCita(request));
    }

    @GetMapping
    public ResponseEntity<List<CitaResponse>> listarTodas() {
        return ResponseEntity.ok(citaService.listarCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.getCitaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaResponse> actualizar(
            @PathVariable Long id, 
            @Valid @RequestBody CitaRequest request) {
        return ResponseEntity.ok(citaService.updateCita(id, request));
    }
}