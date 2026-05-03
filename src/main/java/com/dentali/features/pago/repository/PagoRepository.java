package com.dentali.features.pago.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.features.pago.domain.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{
	
	List<Pago> findByPacienteId(Long pacienteId);
}
