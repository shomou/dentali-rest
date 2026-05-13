package com.dentali.features.paciente.interfaces.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentali.features.paciente.application.dto.request.PacienteRequest;
import com.dentali.features.paciente.application.dto.response.PacienteResponse;
import com.dentali.features.paciente.application.service.PacienteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pacientes")
@RequiredArgsConstructor
public class PacienteController {
    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponse> crear(@RequestBody PacienteRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pacienteService.crear(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listarTodos(){
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
