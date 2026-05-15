package com.dentali.features.paciente.domain.repository;

import java.util.List;
import java.util.Optional;

import com.dentali.features.paciente.domain.model.Paciente;

public interface PacienteRepository {
    Paciente save(Paciente paciente);
    Optional<Paciente> findById(Long id);
    Optional<Paciente> findByIdentificacion(String identificacion);
    List<Paciente> findAll();
    void deleteById(Long id);
}
