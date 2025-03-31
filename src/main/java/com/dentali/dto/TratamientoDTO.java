package com.dentali.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TratamientoDTO {

	private Long id;
	private Long id_paciente;
	private Long id_doctor;
	private Long id_cita;
	private String descripcion;
	private BigDecimal costo;
	private LocalDateTime fecha = LocalDateTime.now();

	// Constructor
	public TratamientoDTO() {

	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Long id_paciente) {
		this.id_paciente = id_paciente;
	}

	public Long getId_doctor() {
		return id_doctor;
	}

	public void setId_doctor(Long id_doctor) {
		this.id_doctor = id_doctor;
	}

	public Long getId_cita() {
		return id_cita;
	}

	public void setId_cita(Long id_cita) {
		this.id_cita = id_cita;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
