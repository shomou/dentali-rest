package com.dentali.features.tratamiento.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.features.tratamiento.domain.Tratamiento;
import com.dentali.features.tratamiento.dto.TratamientoDTO;
import com.dentali.features.tratamiento.mapper.TratamientoMapper;
import com.dentali.features.tratamiento.repository.TratamientoRepository;
import com.dentali.features.tratamiento.service.TratamientoService;

@Service
public class TratamientoServiceImpl implements TratamientoService {

	@Autowired
	TratamientoRepository tratamientoRepository;

	@Autowired
	private TratamientoMapper tratamientoMapper;

	@Override
	@Transactional(readOnly = true)
	public List<TratamientoDTO> obtenerTodos() {

		return tratamientoRepository.findAll().stream()
				.map(tratamientoMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public TratamientoDTO guardar(TratamientoDTO tratamientoDTO) {

		Tratamiento tratamiento = tratamientoMapper.toEntity(tratamientoDTO);

		return tratamientoMapper.toDTO(
				tratamientoRepository
						.save(tratamiento));
	}

	@Override
	@Transactional(readOnly = true)
	public List<TratamientoDTO> buscarPorPaciente(Long id) {
		if (id == null) {
			return List.of();
		}

		return tratamientoRepository.findByPacienteId(id)
				.stream()
				.map(tratamientoMapper::toDTO)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Optional<TratamientoDTO> eliminar(Long id) {
		if (id == null) {
			return Optional.empty();
		}

		Optional<Tratamiento> tratamientoOptional = tratamientoRepository.findById(id);

		tratamientoOptional.ifPresent(tratamientoDb -> {
			tratamientoRepository.delete(tratamientoDb);
		});

		return tratamientoOptional.stream()
				.map(tratamientoMapper::toDTO)
				.findFirst();
	}

	@Override
	@Transactional
	public Optional<TratamientoDTO> actualizar(Long id, TratamientoDTO tratamientoDTO) {
		if (id == null) {
			return Optional.empty();
		}

		Optional<Tratamiento> tratamientoOptional = tratamientoRepository.findById(id);

		if (tratamientoOptional.isPresent()) {
			Tratamiento tratamientoDb = tratamientoOptional.orElseThrow();
			tratamientoDb.setCosto(tratamientoDTO.getCosto());
			tratamientoDb.setDescripcion(tratamientoDTO.getDescripcion());

			Tratamiento tratamientoActualizado = tratamientoRepository.save(tratamientoDb);

			return Optional.of(tratamientoMapper.toDTO(tratamientoActualizado));
		}

		return Optional.empty();
	}

}
