package com.dentali.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.dto.HistorialMedicoDTO;
import com.dentali.repositories.HistorialMedicoRepository;
import com.dentali.services.HistorialMedicoServices;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoServices{

	@Autowired
	private HistorialMedicoRepository historialRepository;
	
	@Override
	@Transactional
	public List<HistorialMedicoDTO> listar() {
		return historialRepository.findAll().stream()
				.map(historial -> new HistorialMedicoDTO(
						historial.getId(), 
						historial.getPaciente().getId(), 
						historial.getDoctor().getId(), 
						historial.getAntecedentes(), 
						historial.getAlergias(), 
						historial.getMedicamentosActuales(), 
						historial.getEnfermedadesCronicas(), 
						historial.getFechaActualizacion()))
				.toList();
	}
	
	
	
}
