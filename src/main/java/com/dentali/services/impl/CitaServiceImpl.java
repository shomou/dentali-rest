package com.dentali.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.entities.Cita;
import com.dentali.repositories.CitaRepository;
import com.dentali.services.CitaService;

@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
    private CitaRepository citaRepository;
	
	@Override
	@Transactional( readOnly = true )
	public List<Cita> listar() {
        return citaRepository.findAll();
    }

	@Override
	@Transactional
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

	
}
