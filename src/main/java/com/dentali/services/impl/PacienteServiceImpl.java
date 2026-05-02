package com.dentali.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.dto.Paciente.PacienteDTO;
import com.dentali.entities.Paciente;
import com.dentali.mapper.PacienteMapper;
import com.dentali.repositories.PacienteRepository;
import com.dentali.services.PacienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private PacienteMapper pacienteMapper;

	@Override
	@Transactional(readOnly = true)
	public List<PacienteDTO> obtenerTodos() {
		return pacienteRepository.findAll().stream()
				.map(pacienteMapper::toDTO)
				.toList();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PacienteDTO> obtenerPorId(Long id) {
		return pacienteRepository.findById(id).stream()
				.map(pacienteMapper::toDTO)
				.findFirst();
	}

	@Override
	@Transactional(readOnly = true)
	public List<PacienteDTO> buscarPorNombre(String nombre) {
		return pacienteRepository.findByNombreContainingIgnoreCase(nombre).stream()
				.map(pacienteMapper::toDTO)
				.toList();
	}

	@Override
	@Transactional
	public PacienteDTO guardar(PacienteDTO pacienteDTO) {
		Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
		paciente.setFechaRegistro(LocalDateTime.now());
		Paciente pacienteDB = pacienteRepository.save(paciente);
		return pacienteMapper.toDTO(pacienteDB);
	}

	@Override
	@Transactional
	public Optional<PacienteDTO> eliminar(Long id) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

		pacienteOptional.ifPresent(pacienteDB -> {
			pacienteRepository.delete(pacienteDB);
		});

		return pacienteOptional.stream()
				.map(pacienteMapper::toDTO)
				.findFirst();
	}

	@Override
	@Transactional
	public Optional<PacienteDTO> update(Long id, PacienteDTO paciente) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);

		if (pacienteOptional.isPresent()) {
			Paciente pacienteDB = pacienteOptional.orElseThrow();
			pacienteDB.setApellido(paciente.getApellido());
			pacienteDB.setDireccion(paciente.getDireccion());
			pacienteDB.setEmail(paciente.getEmail());
			pacienteDB.setFechaNacimiento(paciente.getFechaNacimiento());
			pacienteDB.setNombre(paciente.getNombre());
			pacienteDB.setTelefono(paciente.getTelefono());

			// Guardar el paciente actualizado
			Paciente pacienteActualizado = pacienteRepository.save(pacienteDB);

			return Optional.of(pacienteMapper.toDTO(pacienteActualizado));
		}

		return Optional.empty();
	}

}
