package com.dentali.features.paciente.application.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.features.paciente.application.dto.request.PacienteRequest;
import com.dentali.features.paciente.application.dto.response.PacienteResponse;
import com.dentali.features.paciente.application.mapper.PacienteDtoMapper;
import com.dentali.features.paciente.application.service.PacienteService;
import com.dentali.features.paciente.domain.model.Paciente;
import com.dentali.features.paciente.domain.repository.PacienteRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService{

    private final PacienteRepository repository;
    private final PacienteDtoMapper dtoMapper;
    
    @Override
    @Transactional
    public PacienteResponse crear(PacienteRequest request) {
        // 1. Validar si ya existe por identificación
        repository.findByIdentificacion(request.identificacion())
                .ifPresent(p -> { 
                    throw new RuntimeException("El paciente con esta identificación ya existe"); 
                });

        // 2. Convertir Request a Dominio
        Paciente paciente = dtoMapper.toDomain(request);

        // 3. Guardar usando el adaptador de persistencia
        Paciente pacienteGuardado = repository.save(paciente);

        // 4. Retornar la respuesta formateada
        return dtoMapper.toResponse(pacienteGuardado);
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteResponse buscarPacientePorId(Long id){
        return repository.findById(id)
                    .map(dtoMapper::toResponse)
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteResponse> listarTodos() {
        return repository.findAll().stream()
                .map(dtoMapper::toResponse)
                .collect(Collectors.toList());
    }
    

    @Override
    @Transactional
    public void eliminar(Long id){
        // Validamos que exista
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("No se puede eliminar: Paciente no encontrado");
        }
        repository.deleteById(id);
    }

}