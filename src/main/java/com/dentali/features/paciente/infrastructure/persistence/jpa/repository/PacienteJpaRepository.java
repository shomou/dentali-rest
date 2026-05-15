package com.dentali.features.paciente.infrastructure.persistence.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.features.paciente.infrastructure.persistence.jpa.PacienteEntity;

@Repository
public interface PacienteJpaRepository extends JpaRepository<PacienteEntity, Long>{
    Optional<PacienteEntity> findByIdentificacion(String identificacion);
    
    // Verificar si ya existe un email
    boolean existsByEmail(String email);

}
