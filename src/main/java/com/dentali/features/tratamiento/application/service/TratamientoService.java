package com.dentali.features.tratamiento.application.service;

import java.util.List;

import com.dentali.features.tratamiento.application.dto.request.TratamientoRequest;
import com.dentali.features.tratamiento.application.dto.response.TratamientoResponse;

public interface TratamientoService {

    // Resgistrar un nuevo tratamiento en la bitacora
    TratamientoResponse registrarTratamiento(TratamientoRequest request);

    // Recuperar la bitacora cronologica de tratamientos de un paciente
    List<TratamientoResponse> obtenerHistorialPorPaciente(Long id);

    // Buscar un Tratamiento especifico por su ID único
    TratamientoResponse obtenerPorId (Long id);


}
