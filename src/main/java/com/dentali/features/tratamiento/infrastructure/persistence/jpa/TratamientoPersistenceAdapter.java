package com.dentali.features.tratamiento.infrastructure.persistence.jpa;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dentali.features.tratamiento.domain.model.Tratamiento;
import com.dentali.features.tratamiento.domain.repository.TratamientoRepository;
import com.dentali.features.tratamiento.infrastructure.persistence.jpa.entity.TratamientoEntity;
import com.dentali.features.tratamiento.infrastructure.persistence.jpa.mapper.TratamientoEntityMapper;
import com.dentali.features.tratamiento.infrastructure.persistence.jpa.repository.TratamientoJpaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TratamientoPersistenceAdapter implements TratamientoRepository {

    private final TratamientoJpaRepository jpaRepository;
    private final TratamientoEntityMapper entityMapper;

    @Override
    public Tratamiento guardar(Tratamiento tratamiento) {
        // Convierte el modelo de dominio puro a la entidad de persistencia JPA
        TratamientoEntity entity = entityMapper.toEntity(tratamiento);

        // Guarda en PostgreSQL (aquí la BD le asigna el ID autoincremental si es nuevo)
        TratamientoEntity guardado = jpaRepository.save(entity);

        // Devuelve el registro mapeado de vuelta a objeto de dominio puro
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<Tratamiento> buscarPorId(Long id) {
        return jpaRepository.findById(id)
                .map(entityMapper::toDomain);
    }

    @Override
    public List<Tratamiento> buscarPorPacienteId(Long pacienteId) {
        // Recupera las entidades ordenadas cronológicamente de forma descendente y las
        // convierte a dominio
        return jpaRepository.findByPacienteIdOrderByFechaDesc(pacienteId).stream()
                .map(entityMapper::toDomain)
                .collect(Collectors.toList());
    }

}
