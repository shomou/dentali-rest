package com.dentali.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dentali.dto.Pago.PagoDTO;
import com.dentali.dto.Pago.PagoResponseDTO;
import com.dentali.entities.Pago;
import com.dentali.repositories.PacienteRepository;
import com.dentali.repositories.TratamientoRepository;

@Component
public class PagoMapper {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private TratamientoRepository tratamientoRepository;

	@Autowired
	private PacienteMapper pacienteMapper;

	public PagoDTO toDTO(Pago pago) {
		PagoDTO dto = new PagoDTO();
		dto.setId(pago.getId());
		dto.setPaciente(pago.getPaciente() != null ? pago.getPaciente().getId() : null);
		dto.setTratamiento(pago.getTratamiento() != null ? pago.getTratamiento().getId() : null);
		dto.setMonto(pago.getMonto());
		dto.setMetodoPago(pago.getMetodoPago());
		dto.setFechaPago(pago.getFechaPago());
		return dto;
	}

	public Pago toEntity(PagoDTO dto) {
		Pago pago = new Pago();
		pago.setId(dto.getId());
		pago.setPaciente(dto.getPaciente() != null ? pacienteRepository.findById(dto.getPaciente()).orElse(null) : null);
		pago.setTratamiento(dto.getTratamiento() != null ? tratamientoRepository.findById(dto.getTratamiento()).orElse(null) : null);
		pago.setMonto(dto.getMonto());
		pago.setMetodoPago(dto.getMetodoPago());
		pago.setFechaPago(dto.getFechaPago());
		return pago;
	}

	public PagoResponseDTO toResponseDTO(Pago pago) {
		if (pago == null)
			return null;
		return new PagoResponseDTO(
				pago.getId(),
				pacienteMapper.toResponseDTO(pago.getPaciente()),
				pago.getMonto(),
				pago.getMetodoPago(),
				pago.getFechaPago());
	}
}
