package com.dentali.features.historial.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentali.features.historial.infrastructure.persistence.jpa.HistorialEntity;

public interface HistorialSpringRepository extends JpaRepository<HistorialEntity, Long>{
    Optional<HistorialEntity> findByPacienteId(Long pacienteId);
}
