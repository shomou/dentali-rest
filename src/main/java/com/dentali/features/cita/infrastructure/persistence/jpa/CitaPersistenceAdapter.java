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
        CitaEntity entity = mapper.toEntity(cita);
        CitaEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cita> findById(Long id) {
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
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Cita> findByPacienteId(Long pacienteId) {
        return jpaRepository.findByPacienteId(pacienteId).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Cita> findByDoctorId(Long doctorId) {
        return jpaRepository.findByDoctorId(doctorId).stream()
                .map(mapper::toDomain)
                .toList();
    }
}