package com.dentali.dto.Doctor;

import java.time.LocalDateTime;

public class DoctorResponseDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String especialidad;
	private String telefono;
	private String email;
	private LocalDateTime fechaRegistro;

	public DoctorResponseDTO() {
	}

	public DoctorResponseDTO(Long id, String nombre, String apellido, String especialidad, String telefono,
			String email, LocalDateTime fechaRegistro) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.telefono = telefono;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
