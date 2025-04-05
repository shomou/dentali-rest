package com.dentali.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "historial_medico")
@NoArgsConstructor
@AllArgsConstructor
public class HistorialMedico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = true)
	private Doctor doctor;

	private String antecedentes;
	private String alergias;
	private String medicamentosActuales;
	private String enfermedadesCronicas;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion = LocalDateTime.now();

	// Constructor
	public HistorialMedico(Long id, Paciente paciente, Doctor doctor, String antecedentes, String alergias,
			String medicamentosActuales, String enfermedadesCronicas) {
		this.id = id;
		this.paciente = paciente;
		this.doctor = doctor;
		this.antecedentes = antecedentes;
		this.alergias = alergias;
		this.medicamentosActuales = medicamentosActuales;
		this.enfermedadesCronicas = enfermedadesCronicas;
	}

	// Getter y Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
