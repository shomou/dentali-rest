package com.dentali.dto;

import java.time.LocalDateTime;

import com.dentali.enums.EstadoCita;

public class CitaDTO {

	private Long id;
	private Long id_paciente;
	private Long id_odontologo;
	private String motivo;
	private EstadoCita estado;
	private LocalDateTime fecha;

	// Constructor
	public CitaDTO(Long id, Long id_paciente, Long id_odontologo, String motivo, EstadoCita estado,
			LocalDateTime fecha) {
		this.id = id;
		this.id_paciente = id_paciente;
		this.id_odontologo = id_odontologo;
		this.motivo = motivo;
		this.estado = estado;
		this.fecha = fecha;
	}

	// Constructor por defecto necesario para deserialización
	public CitaDTO() {
	}

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

	public Long getId_odontologo() {
		return id_odontologo;
	}

	public void setId_odontologo(Long id_odontologo) {
		this.id_odontologo = id_odontologo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public EstadoCita getEstado() {
		return estado;
	}

	public void setEstado(EstadoCita estado) {
		this.estado = estado;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
