package com.dentali.features.historial.domain.repository;

import java.util.Optional;

import com.dentali.features.historial.domain.model.HistoriaClinica;

public interface HistorialRepository {

    HistoriaClinica guardar( HistoriaClinica historial);
    Optional <HistoriaClinica> buscarPorId(Long id);
    Optional <HistoriaClinica> buscarPorPacienteId(Long pacienteId);
   
}
