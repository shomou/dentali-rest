package com.dentali.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistorialMedicoDTO {

	private Long id;
	
	@JsonProperty("paciente_id")
	private Long idPaciente;
	
	@JsonProperty("doctor_id")
	private Long idDoctor;
	
	private String antecedentes;
	private String alergias;
	private String medicamentosActuales;
	private String enfermedadesCronicas;
	private LocalDateTime fechaActualizacion;
	
	// Constructor
	public HistorialMedicoDTO(Long id, Long idPaciente, Long idDoctor, String antecedentes, String alergias,
			String medicamentosActuales, String enfermedadesCronicas, LocalDateTime fechaActualizacion) {
		this.id = id;
		this.idPaciente = idPaciente;	
		this.idDoctor = idDoctor;
		this.antecedentes = antecedentes;
		this.alergias = alergias;
		this.medicamentosActuales = medicamentosActuales;
		this.enfermedadesCronicas = enfermedadesCronicas;
		this.fechaActualizacion = fechaActualizacion;	
	}

	// Constructor por defecto necesario para deserialización
	public HistorialMedicoDTO() {
	}

	// Getters & Setters
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

	public Long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getMedicamentosActuales() {
		return medicamentosActuales;
	}

	public void setMedicamentosActuales(String medicamentosActuales) {
		this.medicamentosActuales = medicamentosActuales;
	}

	public String getEnfermedadesCronicas() {
		return enfermedadesCronicas;
	}

	public void setEnfermedadesCronicas(String enfermedadesCronicas) {
		this.enfermedadesCronicas = enfermedadesCronicas;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
}
