package com.dentali.features.paciente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.features.paciente.domain.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	List<Paciente> findByNombreContainingIgnoreCase(String nombre);
	

}
