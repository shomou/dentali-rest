package com.dentali.features.tratamiento.service;

import java.util.List;
import java.util.Optional;

import com.dentali.features.tratamiento.dto.TratamientoDTO;

public interface TratamientoService {

	public List<TratamientoDTO> obtenerTodos();

	public TratamientoDTO guardar(TratamientoDTO tratamientodto);

	public List<TratamientoDTO> buscarPorPaciente(Long id);

	public Optional<TratamientoDTO> eliminar(Long id);

	Optional<TratamientoDTO> actualizar(Long id, TratamientoDTO tratamientoDTO);

}
