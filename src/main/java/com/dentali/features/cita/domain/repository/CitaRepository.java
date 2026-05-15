package com.dentali.features.cita.domain.repository;

import java.util.List;
import java.util.Optional;

import com.dentali.features.cita.domain.model.Cita;

public interface CitaRepository {

    Cita save(Cita cita);
    Optional<Cita> findById(Long id);
    List<Cita> findAll();
    void deleteById(Long id);

    // Métodos de búsqueda necesarios para la lógica de negocio
    List<Cita> findByPacienteId(Long pacienteId);
    List<Cita> findByDoctorId(Long doctorId);
}
