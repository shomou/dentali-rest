package com.dentali.dto.Tratamiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.dentali.dto.Doctor.DoctorResponseDTO;
import com.dentali.dto.Paciente.PacienteResponseDTO;

public class TratamientoResponseDTO {

	private Long id;
	private PacienteResponseDTO paciente;
	private DoctorResponseDTO doctor;
	private String descripcion;
	private BigDecimal costo;
	private LocalDateTime fecha;

	public TratamientoResponseDTO() {
	}

	public TratamientoResponseDTO(Long id, PacienteResponseDTO paciente, DoctorResponseDTO doctor, String descripcion,
			BigDecimal costo, LocalDateTime fecha) {
		this.id = id;
		this.paciente = paciente;
		this.doctor = doctor;
		this.descripcion = descripcion;
		this.costo = costo;
		this.fecha = fecha;
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

	public DoctorResponseDTO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorResponseDTO doctor) {
		this.doctor = doctor;
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
