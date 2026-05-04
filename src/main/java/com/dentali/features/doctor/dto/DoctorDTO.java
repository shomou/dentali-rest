package com.dentali.features.doctor.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DoctorDTO {

	private Long id;
	private String nombre;
	private String apellido;
	private String especialidad;
	private String telefono;
	private String email;

	@NotBlank(message = "La contraseña no puede estar vacía")
	@Size(min = 6, message = "Debe tener al menos 6 caracteres")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String role; // Campo para el rol (ej: ROLE_DOCTOR, ROLE_ADMIN)

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private LocalDate fechaRegistro;
	private Long userId;

	// Constructor
	public DoctorDTO() {

	}

	public DoctorDTO(Long id, String nombre, String apellido, String especialidad, String telefono, String email,
			LocalDate fechaRegistro, String password, String role) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.telefono = telefono;
		this.email = email;
		this.fechaRegistro = fechaRegistro;
		this.password = password;
		this.role = role;
	}

	// Getters & Setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
