package com.dentali.features.historial.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.features.historial.application.dto.request.HistoriaClinicaRequest;
import com.dentali.features.historial.application.dto.response.HistoriaClinicaResponse;
import com.dentali.features.historial.application.service.HistoriaClinicaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/historias-clinicas")
@RequiredArgsConstructor
public class HistoriaClinicaController {

    private final HistoriaClinicaService service;

    @PostMapping
    public ResponseEntity<HistoriaClinicaResponse> crear(@RequestBody HistoriaClinicaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(service.registrar(request));
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<HistoriaClinicaResponse> obtenerPorPaciente(@PathVariable Long pacienteId) {
    return service.buscarPorPaciente(pacienteId)
            .map(ResponseEntity::ok) // Si existe, 200 OK con el DTO
            .orElse(ResponseEntity.notFound().build()); // Si no, 404 Not Found
}

}
