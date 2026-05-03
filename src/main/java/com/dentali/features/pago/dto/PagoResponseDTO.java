package com.dentali.features.pago.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.dentali.core.enums.MetodoPago;
import com.dentali.features.paciente.dto.PacienteResponseDTO;

public class PagoResponseDTO {

	private Long id;
	private PacienteResponseDTO paciente;
	private BigDecimal monto;
	private MetodoPago metodoPago;
	private LocalDateTime fechaPago;

	public PagoResponseDTO() {
	}

	public PagoResponseDTO(Long id, PacienteResponseDTO paciente, BigDecimal monto, MetodoPago metodoPago,
			LocalDateTime fechaPago) {
		this.id = id;
		this.paciente = paciente;
		this.monto = monto;
		this.metodoPago = metodoPago;
		this.fechaPago = fechaPago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PacienteResponseDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteResponseDTO paciente) {
		this.paciente = paciente;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}
}
