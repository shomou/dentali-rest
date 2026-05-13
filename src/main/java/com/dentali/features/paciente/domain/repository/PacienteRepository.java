package com.dentali.features.paciente.domain.repository;

import java.util.List;
import java.util.Optional;

import com.dentali.features.paciente.domain.model.Paciente;

public interface PacienteRepository {
    Paciente guardar(Paciente paciente);
    Optional<Paciente> buscarPorId(Long id);
    Optional<Paciente> buscarPorIdentificacion(String identificacion);
    List<Paciente> obtenerTodos();
    void eliminar(Long id);
}
