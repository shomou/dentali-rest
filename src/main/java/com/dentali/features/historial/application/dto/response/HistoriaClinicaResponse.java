package com.dentali.features.historial.application.dto.response;

import java.time.LocalDate;
import java.util.Map;

public record HistoriaClinicaResponse (
    Long id,
    Long pacienteId,
    String numeroExpediente,
    LocalDate fechaIngreso,
    String motivoConsulta,
    String nombrePaciente, // Podrías combinar datos aquí si fuera necesario
    String estadoSaludGeneral, // Un resumen calculado o campo del dominio
    Map<String, String> alertasMedicas // Solo las enfermedades que marcaron "SI"
){
    
}
