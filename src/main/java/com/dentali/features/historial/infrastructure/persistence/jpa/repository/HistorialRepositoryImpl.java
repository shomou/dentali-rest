package com.dentali.features.historial.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dentali.features.historial.domain.model.HistoriaClinica;
import com.dentali.features.historial.domain.repository.HistorialRepository;
import com.dentali.features.historial.infrastructure.persistence.jpa.HistorialEntity;
import com.dentali.features.historial.infrastructure.persistence.mapper.HistorialMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HistorialRepositoryImpl implements HistorialRepository{

    private final HistorialSpringRepository springRepository;
    private final HistorialMapper mapper;

    @Override
    public HistoriaClinica guardar(HistoriaClinica historial) {
        if (historial == null) {
            throw new IllegalArgumentException("La historia clínica no puede ser nula");
        }
        // 1. Convertir Dominio -> Entity
        HistorialEntity entity = mapper.toEntity(historial);

        if (entity == null) {
            throw new IllegalStateException("Error interno: No se pudo mapear la historia clínica a la entidad de persistencia");
        }
        
        // 2. Guardar en Postgres
        HistorialEntity savedEntity = springRepository.save(entity);
        
        // 3. Convertir Entity -> Dominio y retornar
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<HistoriaClinica> buscarPorId(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return springRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<HistoriaClinica> buscarPorPacienteId(Long pacienteId) {
        if (pacienteId == null) {
            return Optional.empty();
        }
        return springRepository.findByPacienteId(pacienteId)
                .map(mapper::toDomain);
    }

}
