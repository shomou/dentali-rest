package com.dentali.features.paciente.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dentali.features.paciente.domain.model.Paciente;
import com.dentali.features.paciente.domain.repository.PacienteRepository;
import com.dentali.features.paciente.infrastructure.persistence.jpa.repository.PacienteJpaRepository;
import com.dentali.features.paciente.infrastructure.persistence.jpa.mapper.PacienteEntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PacientePersistenceAdapter implements PacienteRepository{

    private final PacienteJpaRepository jpaRepository;
    private final PacienteEntityMapper mapper;

    @Override
    public Paciente save(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }
        // 1. Convertimos el objeto de dominio a Entidad de JPA
        PacienteEntity entity = mapper.toEntity(paciente);
        
        if (entity == null) {
            throw new IllegalStateException("Error interno: No se pudo mapear el paciente a la entidad de persistencia");
        }
        
        // 2. Persistimos en la base de datos
        PacienteEntity savedEntity = jpaRepository.save(entity);
        
        // 3. Devolvemos el resultado convertido de nuevo a Dominio
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Paciente> findByIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.isBlank()) {
            return Optional.empty();
        }
        return jpaRepository.findByIdentificacion(identificacion)
                .map(mapper::toDomain);
    }

    @Override
    public List<Paciente> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        jpaRepository.deleteById(id);
    }

}
