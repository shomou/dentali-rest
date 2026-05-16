package com.dentali.features.tratamiento.domain.repository;

import java.util.List;
import java.util.Optional;

import com.dentali.features.tratamiento.domain.model.Tratamiento;

public interface TratamientoRepository {

    // Guarda o actualiza un tratamiento en el sistema
    Tratamiento guardar(Tratamiento tratamiento);
    
    // Recupera un tratamiento específico mediante su ID único
    Optional<Tratamiento> buscarPorId(Long id);
    
    // Recupera todos los tratamientos asociados a un paciente específico
    List<Tratamiento> buscarPorPacienteId(Long pacienteId);

}
