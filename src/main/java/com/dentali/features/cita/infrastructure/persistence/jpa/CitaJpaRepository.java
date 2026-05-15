package com.dentali.features.cita.infrastructure.persistence.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaJpaRepository extends JpaRepository<CitaEntity, Long> {
    List<CitaEntity> findByPacienteId(Long pacienteId);
    List<CitaEntity> findByDoctorId(Long doctorId);
}