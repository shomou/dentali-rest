package com.dentali.services;

import java.util.List;
import java.util.Optional;

import com.dentali.dto.Tratamiento.TratamientoDTO;

public interface TratamientoService {

	public List<TratamientoDTO> obtenerTodos();

	public TratamientoDTO guardar(TratamientoDTO tratamientodto);

	public List<TratamientoDTO> buscarPorPaciente(Long id);

	public Optional<TratamientoDTO> eliminar(Long id);

	Optional<TratamientoDTO> actualizar(Long id, TratamientoDTO tratamientoDTO);

}
