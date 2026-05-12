package com.dentali.features.historial.application.dto.request;

import java.util.Map;

import com.dentali.features.historial.domain.enums.EstadoCivil;
import com.dentali.features.historial.domain.enums.Genero;

public record HistoriaClinicaRequest(
    Long pacienteId,
    String motivoConsulta,
    String numeroExpediente,
    
    // Datos de identificación que vienen del front
    Genero genero,
    EstadoCivil estadoCivil,
    String ocupacion,
    String religion,
    String nacionalidad,
    String domicilio,
    String telefonoPaciente,

    // Signos Vitales planos
    Double peso,
    Double talla,
    String grupoSanguineo,
    String presionArterial,
    Integer fr,
    Integer fc,
    Double temperatura,
    Integer saturacionO2,

    // Antecedentes y Mapas
    Map<String, String> padecimientosFamiliares,
    String observacionesFamiliares,
    Map<String, String> padecimientosPatologicos,
    String enfermedadesUltimoAno,
    String observacionesPatologicas,
    
    // Otros
    String planTratamiento
) {    

}
