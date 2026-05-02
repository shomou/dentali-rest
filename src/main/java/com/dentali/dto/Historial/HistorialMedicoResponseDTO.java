package com.dentali.dto.Historial;

import java.time.LocalDateTime;

import com.dentali.dto.Doctor.DoctorResponseDTO;
import com.dentali.dto.Paciente.PacienteResponseDTO;

public class HistorialMedicoResponseDTO {

	private Long id;
	private PacienteResponseDTO paciente;
	private DoctorResponseDTO doctor;
	private String antecedentes;
	private String alergias;
	private String medicamentosActuales;
	private String enfermedadesCronicas;
	private LocalDateTime fechaActualizacion;

	public HistorialMedicoResponseDTO() {
	}

	public HistorialMedicoResponseDTO(Long id, PacienteResponseDTO paciente, DoctorResponseDTO doctor,
			String antecedentes, String alergias, String medicamentosActuales, String enfermedadesCronicas,
			LocalDateTime fechaActualizacion) {
		this.id = id;
		this.paciente = paciente;
		this.doctor = doctor;
		this.antecedentes = antecedentes;
		this.alergias = alergias;
		this.medicamentosActuales = medicamentosActuales;
		this.enfermedadesCronicas = enfermedadesCronicas;
		this.fechaActualizacion = fechaActualizacion;
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
