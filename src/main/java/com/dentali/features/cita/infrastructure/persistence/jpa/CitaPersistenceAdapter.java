package com.dentali.features.cita.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.dentali.features.cita.domain.model.Cita;
import com.dentali.features.cita.domain.repository.CitaRepository;
import com.dentali.features.cita.infrastructure.persistence.jpa.mapper.CitaEntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CitaPersistenceAdapter implements CitaRepository {

    private final CitaJpaRepository jpaRepository;
    private final CitaEntityMapper mapper;

    @Override
    public Cita save(Cita cita) {
        if (cita == null) {
            throw new IllegalArgumentException("La cita no puede ser nula");
        }
        CitaEntity entity = mapper.toEntity(cita);

        if (entity == null) {
            throw new IllegalStateException("Error interno: No se pudo mapear la cita a la entidad de persistencia");
        }

        CitaEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cita> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Cita> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Cita> findByPacienteId(Long pacienteId) {
        if (pacienteId == null) {
            return List.of();
        }
        return jpaRepository.findByPacienteId(pacienteId).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Cita> findByDoctorId(Long doctorId) {
        if (doctorId == null) {
            return List.of();
        }
        return jpaRepository.findByDoctorId(doctorId).stream()
                .map(mapper::toDomain)
                .toList();
    }
}