package com.dentali.services;

import java.util.List;
import java.util.Optional;

import com.dentali.entities.Doctor;

public interface DoctorService {
	public List<Doctor> obtenerTodos();

	public Optional<Doctor> obtenerPorId(Long id);

	public List<Doctor> buscarPorEspecialidad(String especialidad);

	public Doctor guardar(Doctor doctor);

	public Optional<Doctor> eliminar(Long id);
	
	Optional<Doctor> update(Long id, Doctor doctor);
}
