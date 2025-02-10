package com.dentali.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.entities.Doctor;
import com.dentali.repositories.DoctorRepository;
import com.dentali.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	@Transactional( readOnly = true )
    public List<Doctor> obtenerTodos() {
        return doctorRepository.findAll();
    }

	@Override
	@Transactional( readOnly = true )
    public Optional<Doctor> obtenerPorId(Long id) {
        return doctorRepository.findById(id);
    }

	@Override
	@Transactional( readOnly = true )
    public List<Doctor> buscarPorEspecialidad(String especialidad) {
        return doctorRepository.findByEspecialidadIgnoreCase(especialidad);
    }

	@Override
	@Transactional
    public Doctor guardar(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

	@Override
	public Optional<Doctor> eliminar(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Doctor> update(Long id, Doctor doctor) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
