package com.dentali.features.paciente.dto;

import java.time.LocalDate;

import com.dentali.features.historial.domain.enums.EstadoCivil;
import com.dentali.features.historial.domain.enums.Genero;
import com.dentali.features.historial.domain.enums.Nacionalidad;
import com.dentali.features.historial.domain.enums.Ocupaciones;
import com.dentali.features.historial.domain.enums.Religion;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class PacienteDTO {

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	@NotBlank(message = "El apellido es obligatorio")
	private String apellido;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaNacimiento;
	private Genero genero;
	private EstadoCivil estadoCivil;
	private Ocupaciones ocupacion;
	private Religion religion;
	private Nacionalidad nacionalidad;
	private String telefono;
	@Email(message = "Formato de email inválido")
	@NotBlank(message = "El email es obligatorio")
	private String email;
	private String direccion;	
	private Boolean estado;

	// Constructor
	public PacienteDTO() {

	}

	public PacienteDTO(String nombre, String apellido, LocalDate fechaNacimiento,
			Genero genero, EstadoCivil estadoCivil, Ocupaciones ocupacion, Religion religion, 
			Nacionalidad nacionalidad, String telefono, String email, String direccion, Boolean estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.ocupacion = ocupacion;
		this.religion = religion;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.estado = estado;
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

	public Genero getGenero(){
		return genero;
	
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Ocupaciones getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupaciones ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Religion getReligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
