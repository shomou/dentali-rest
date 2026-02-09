package com.dentali.dto;

import java.time.LocalDateTime;

public class HistorialMedicoDTO {

	private Long id;
	private Long paciente_id;
	private Long doctor_id;
	private String antecedentes;
	private String alergias;
	private String medicamentosActuales;
	private String enfermedadesCronicas;
	private LocalDateTime fechaActualizacion;
	
	// Constructor
	public HistorialMedicoDTO(Long id, Long paciente_id, Long doctor_id, String antecedentes, String alergias,
			String medicamentosActuales, String enfermedadesCronicas, LocalDateTime fechaActualizacion) {
		this.id = id;
		this.paciente_id = paciente_id;	
		this.doctor_id = doctor_id;
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

	public Long getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(Long paciente_id) {
		this.paciente_id = paciente_id;
	}

	public Long getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Long doctor_id) {
		this.doctor_id = doctor_id;
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
