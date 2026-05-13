package com.dentali.features.paciente.application.service;

import java.util.List;

import com.dentali.features.paciente.application.dto.request.PacienteRequest;
import com.dentali.features.paciente.application.dto.response.PacienteResponse;

public interface PacienteService {

    PacienteResponse crear(PacienteRequest request);
    PacienteResponse buscarPorId(Long id);
    List<PacienteResponse> listarTodos();
    void eliminar(Long id);
    
} 
