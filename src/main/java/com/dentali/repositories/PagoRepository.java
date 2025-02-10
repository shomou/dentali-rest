package com.dentali.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.entities.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{
	
	List<Pago> findByPacienteId(Long pacienteId);
}
