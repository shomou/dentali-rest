package com.dentali.features.tratamiento.interfaces.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.features.tratamiento.application.dto.request.TratamientoRequest;
import com.dentali.features.tratamiento.application.dto.response.TratamientoResponse;
import com.dentali.features.tratamiento.application.service.TratamientoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/tratamientos")
@RequiredArgsConstructor
public class TratamientoController {
    private final TratamientoService tratamientoService;

    @PostMapping
    public ResponseEntity<TratamientoResponse> registrarTratamiento(@Valid @RequestBody TratamientoRequest request) {
        TratamientoResponse respuesta = tratamientoService.registrarTratamiento(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @GetMapping("/paciente/{pacienteId}")
    public ResponseEntity<List<TratamientoResponse>> obtenerHistorialPorPaciente(@PathVariable Long pacienteId) {
        List<TratamientoResponse> historial = tratamientoService.obtenerHistorialPorPaciente(pacienteId);
        return ResponseEntity.ok(historial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TratamientoResponse> obtenerPorId(@PathVariable Long id) {
        TratamientoResponse tratamiento = tratamientoService.obtenerPorId(id);
        return ResponseEntity.ok(tratamiento);
    }

}
