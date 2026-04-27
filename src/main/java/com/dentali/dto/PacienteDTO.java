package com.dentali.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PacienteDTO {

	private Long id;
	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	@NotBlank(message = "El apellido es obligatorio")
	private String apellido;
	private LocalDate fechaNacimiento;
	private String telefono;
	@Email(message = "Formato de email inválido")
	@NotBlank(message = "El email es obligatorio")
	private String email;
	private String direccion;
	private LocalDateTime fechaRegistro;

	// Constructor
	public PacienteDTO() {

	}

	public PacienteDTO(Long id, String nombre, String apellido, LocalDate fechaNacimiento,
			String telefono, String email, String direccion, LocalDateTime fechaRegistro) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.fechaRegistro = fechaRegistro;

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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
