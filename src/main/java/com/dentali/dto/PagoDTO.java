package com.dentali.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.dentali.Enum.MetodoPago;

public class PagoDTO {

	private Long id;
	private Long paciente;
	private Long tratamiento;
	private BigDecimal monto;
	private MetodoPago metodoPago;
	private LocalDateTime fechaPago;

	// Constructor
	public PagoDTO() {

	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPaciente() {
		return paciente;
	}

	public void setPaciente(Long paciente) {
		this.paciente = paciente;
	}

	public Long getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Long tratamiento) {
		this.tratamiento = tratamiento;
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
