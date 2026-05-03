package com.dentali.features.cita.dto;

import java.time.LocalDateTime;

import com.dentali.core.enums.EstadoCita;
import com.dentali.features.doctor.dto.DoctorResponseDTO;
import com.dentali.features.paciente.dto.PacienteResponseDTO;

public class CitaResponseDTO {

	private Long id;
	private PacienteResponseDTO paciente;
	private DoctorResponseDTO doctor;
	private String motivo;
	private EstadoCita estado;
	private LocalDateTime fecha;
	private LocalDateTime fechaCreacion;

	public CitaResponseDTO() {
	}

	public CitaResponseDTO(Long id, PacienteResponseDTO paciente, DoctorResponseDTO doctor, String motivo,
			EstadoCita estado, LocalDateTime fecha, LocalDateTime fechaCreacion) {
		this.id = id;
		this.paciente = paciente;
		this.doctor = doctor;
		this.motivo = motivo;
		this.estado = estado;
		this.fecha = fecha;
		this.fechaCreacion = fechaCreacion;
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

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
