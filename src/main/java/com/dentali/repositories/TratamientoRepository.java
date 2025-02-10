package com.dentali.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.entities.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
	List<Tratamiento> findByPacienteId( Long pacienteId);
	List<Tratamiento> findByDoctorId(Long doctorId);
	
}
