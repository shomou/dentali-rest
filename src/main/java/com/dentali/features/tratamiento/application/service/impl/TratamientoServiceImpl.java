package com.dentali.features.tratamiento.application.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.core.exceptions.ResourceNotFoundException;
import com.dentali.features.tratamiento.application.dto.request.TratamientoRequest;
import com.dentali.features.tratamiento.application.dto.response.TratamientoResponse;
import com.dentali.features.tratamiento.application.mapper.TratamientoDtoMapper;
import com.dentali.features.tratamiento.application.service.TratamientoService;
import com.dentali.features.tratamiento.domain.model.Tratamiento;
import com.dentali.features.tratamiento.domain.repository.TratamientoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TratamientoServiceImpl implements TratamientoService {

    private final TratamientoRepository tratamientoRepository;
    private final TratamientoDtoMapper dtoMApper;

    @Override
    @Transactional(readOnly = true)
    public List<TratamientoResponse> obtenerHistorialPorPaciente(Long pacienteId) {
        return tratamientoRepository.buscarPorPacienteId(pacienteId)
                .stream()
                .map(dtoMApper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TratamientoResponse obtenerPorId(Long id) {

        return tratamientoRepository.buscarPorId(id)
                .map(dtoMApper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Tratamiento no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public TratamientoResponse registrarTratamiento(TratamientoRequest request) {
        // MapStruct se encarga de instanciar el dominio con sus valores
        Tratamiento nuevoTratamiento = dtoMApper.toDomain(request);
        // Guardamos en la BD
        Tratamiento guardado = tratamientoRepository.guardar(nuevoTratamiento);
        // Devolvemos la respuesta mapeada
        return dtoMApper.toResponse(guardado);
    }

}
