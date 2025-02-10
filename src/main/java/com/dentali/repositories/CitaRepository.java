package com.dentali.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.Enum.EstadoCita;
import com.dentali.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
	List<Cita> findByPacienteId(Long pacienteId);
    List<Cita> findByDoctorId(Long doctorId);
    List<Cita> findByEstado(EstadoCita estado);
}
