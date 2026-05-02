package com.dentali.dto.Cita;

import java.time.LocalDateTime;

import com.dentali.enums.EstadoCita;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CitaDTO {

	private Long id;

	@JsonProperty("paciente_id")
	private Long idPaciente;

	@JsonProperty("doctor_id")
	private Long idOdontologo;

	private String motivo;
	private EstadoCita estado;
	private LocalDateTime fecha;

	// Constructor
	public CitaDTO(Long id, Long idPaciente, Long idOdontologo, String motivo, EstadoCita estado,
			LocalDateTime fecha) {
		this.id = id;
		this.idPaciente = idPaciente;
		this.idOdontologo = idOdontologo;
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

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Long getIdOdontologo() {
		return idOdontologo;
	}

	public void setIdOdontologo(Long idOdontologo) {
		this.idOdontologo = idOdontologo;
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
