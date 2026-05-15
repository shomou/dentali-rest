package com.dentali.features.cita.application.service;

import java.util.List;

import com.dentali.features.cita.application.dto.request.CitaRequest;
import com.dentali.features.cita.application.dto.response.CitaResponse;

public interface CitaService {

    CitaResponse createCita(CitaRequest request);
    List<CitaResponse> listarCitas();
    CitaResponse getCitaById(Long id);
    CitaResponse updateCita(Long id, CitaRequest request);


}
