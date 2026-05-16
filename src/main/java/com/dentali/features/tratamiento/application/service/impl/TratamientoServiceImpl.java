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
import com.dentali.features.paciente.domain.repository.PacienteRepository;
import com.dentali.features.doctor.domain.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TratamientoServiceImpl implements TratamientoService {

    private final TratamientoRepository tratamientoRepository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final TratamientoDtoMapper dtoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TratamientoResponse> obtenerHistorialPorPaciente(Long pacienteId) {
        return tratamientoRepository.buscarPorPacienteId(pacienteId)
                .stream()
                .map(dtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TratamientoResponse obtenerPorId(Long id) {

        return tratamientoRepository.buscarPorId(id)
                .map(dtoMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Tratamiento no encontrado con ID: " + id));
    }

    @Override
    @Transactional
    public TratamientoResponse registrarTratamiento(TratamientoRequest request) {
        // Validamos que el paciente y el doctor existan
        if (pacienteRepository.findById(request.pacienteId()).isEmpty()) {
            throw new ResourceNotFoundException("Paciente no encontrado con ID: " + request.pacienteId());
        }
        if (doctorRepository.findById(request.doctorId()).isEmpty()) {
            throw new ResourceNotFoundException("Doctor no encontrado con ID: " + request.doctorId());
        }

        // MapStruct se encarga de instanciar el dominio con sus valores
        Tratamiento nuevoTratamiento = dtoMapper.toDomain(request);
        // Guardamos en la BD
        Tratamiento guardado = tratamientoRepository.guardar(nuevoTratamiento);
        // Devolvemos la respuesta mapeada
        return dtoMapper.toResponse(guardado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TratamientoResponse> obtenerPorDoctor(Long doctorId) {
        return tratamientoRepository.buscarPorDoctorId(doctorId).stream()
                .map(dtoMapper::toResponse)
                .collect(Collectors.toList());
    }

}
