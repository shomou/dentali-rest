package com.dentali.features.doctor.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.doctor.dto.DoctorDTO;
import com.dentali.features.doctor.mapper.DoctorMapper;
import com.dentali.features.doctor.repository.DoctorRepository;
import com.dentali.features.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private DoctorMapper doctorMapper;

	@Override
	@Transactional(readOnly = true)
	public List<DoctorDTO> obtenerTodos() {
		return doctorRepository.findAll().stream()
				.map(doctorMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DoctorDTO> obtenerPorId(Long id) {
		return doctorRepository.findById(id)
				.map(doctorMapper::toDTO);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DoctorDTO> buscarPorEspecialidad(String especialidad) {
		return doctorRepository.findByEspecialidadIgnoreCase(especialidad).stream()
				.map(doctorMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public DoctorDTO guardar(DoctorDTO doctorDTO) {
		// Convertir un DTO a una entidad
		Doctor doctor = doctorMapper.toEntity(doctorDTO);
		return doctorMapper.toDTO(doctorRepository.save(doctor));
	}

	@Override
	public Optional<DoctorDTO> eliminar(Long id) {
		return doctorRepository.findById(id).map(doctor -> {
			doctorRepository.delete(doctor);
			return doctorMapper.toDTO(doctor);
		});
	}

	@Override
	public Optional<DoctorDTO> update(Long id, DoctorDTO doctorDTO) {
		return doctorRepository.findById(id).map(existingDoctor -> {
			// Actualizar los campos del doctor existente con los datos del DTO
			existingDoctor.setNombre(doctorDTO.getNombre());
			existingDoctor.setEspecialidad(doctorDTO.getEspecialidad());
			existingDoctor.setTelefono(doctorDTO.getTelefono());
			// Guardar los cambios
			Doctor updatedDoctor = doctorRepository.save(existingDoctor);
			return doctorMapper.toDTO(updatedDoctor);
		});
	}
}
