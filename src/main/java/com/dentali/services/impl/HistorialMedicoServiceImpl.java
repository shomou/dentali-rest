package com.dentali.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.entities.HistorialMedico;
import com.dentali.repositories.HistorialMedicoRepository;
import com.dentali.services.HistorialMedicoServices;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoServices{

	@Autowired
	private HistorialMedicoRepository historialRepository;
	
	@Override
	@Transactional
	public List<HistorialMedico> listar() {
		return historialRepository.findAll();
	}
	
	
	
}
