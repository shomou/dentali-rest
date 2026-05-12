package com.dentali.features.historial.application.service;

import java.util.Optional;

import com.dentali.features.historial.application.dto.request.HistoriaClinicaRequest;
import com.dentali.features.historial.application.dto.response.HistoriaClinicaResponse;


public interface HistoriaClinicaService {
    HistoriaClinicaResponse registrar(HistoriaClinicaRequest request);
    Optional<HistoriaClinicaResponse> buscarPorPaciente(Long pacienteId);
}
