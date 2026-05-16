package com.dentali.features.tratamiento.infrastructure.persistence.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.features.tratamiento.infrastructure.persistence.jpa.entity.TratamientoEntity;

@Repository
public interface TratamientoJpaRepository extends JpaRepository<TratamientoEntity, Long> {
    
    // Recupera el historial de tratamientos de un paciente ordenados por fecha descendente (el más reciente primero)
    List<TratamientoEntity> findByPacienteIdOrderByFechaDesc(Long pacienteId);
    
    // Opcional: Por si en el futuro necesitas saber qué tratamientos se hicieron en una cita específica
    List<TratamientoEntity> findByCitaId(Long citaId);
    
    // Recupera los tratamientos realizados por un doctor específico
    List<TratamientoEntity> findByDoctorIdOrderByFechaDesc(Long doctorId);
}