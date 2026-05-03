package com.dentali.features.cita.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.core.enums.EstadoCita;
import com.dentali.features.cita.domain.Cita;
import com.dentali.features.cita.dto.CitaDTO;
import com.dentali.features.cita.mapper.CitaMapper;
import com.dentali.features.cita.repository.CitaRepository;
import com.dentali.features.cita.service.CitaService;
import com.dentali.features.doctor.repository.DoctorRepository;

@Service
public class CitaServiceImpl implements CitaService {

	@Autowired
	private CitaRepository citaRepository;

	@Autowired
	private DoctorRepository repositoryD;

	@Autowired
	private CitaMapper citaMapper;

	// Listar Citas
	@Override
	@Transactional(readOnly = true)
	public List<CitaDTO> listar() {

		return citaRepository.findAll().stream()
				.map(citaMapper::toDTO)
				.collect(Collectors.toList());

	}

	// Buscar Cita por ID
	@Override
	@Transactional(readOnly = true)
	public Optional<CitaDTO> obtenerCita(Long id) {

		return citaRepository.findById(id)
				.map(citaMapper::toDTO);

	}

	// Guardar Cita
	@Override
	@Transactional
	public CitaDTO guardar(CitaDTO citaDTO) {
		// Convertir un DTO a una entidad
		Cita cita = citaMapper.toEntity(citaDTO);
		return citaMapper.toDTO(citaRepository.save(cita));
	}

	// Actualizar Cita
	@Override
	@Transactional
	public Optional<CitaDTO> actualizar(Long id, CitaDTO citaDTO) {

		Optional<Cita> citaOptional = citaRepository.findById(id);

		if (citaOptional.isPresent()) {
			Cita citaDB = citaOptional.orElseThrow();

			if (citaDTO.getIdOdontologo() != null) {
				citaDB.setDoctor(repositoryD.findById(citaDTO.getIdOdontologo()).orElse(null));
			}

			citaDB.setMotivo(citaDTO.getMotivo());

			// Guardar la cita con la cancelación
			Cita citaActualizada = citaRepository.save(citaDB);

			return Optional.of(citaMapper.toDTO(citaActualizada));
		}
		return Optional.empty();

	}

	// Cancelar Cita
	@Override
	@Transactional
	public Optional<CitaDTO> cancelar(Long id, CitaDTO citaDTO) {

		Optional<Cita> citaOptional = citaRepository.findById(id);

		EstadoCita estado = EstadoCita.CANCELADA;

		if (citaOptional.isPresent()) {
			Cita citaDB = citaOptional.orElseThrow();
			citaDB.setEstado(estado);
			citaDB.setMotivo(citaDTO.getMotivo());

			// Guardar la cita con la cancelación
			Cita citaActualizada = citaRepository.save(citaDB);

			// Convertir la entidad ewn DTO y regresamos la respuesta
			return Optional.of(citaMapper.toDTO(citaActualizada));
		}

		return Optional.empty();
	}

}
