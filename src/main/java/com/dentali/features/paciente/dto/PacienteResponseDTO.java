package com.dentali.features.paciente.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.dentali.features.historial.domain.enums.EstadoCivil;
import com.dentali.features.historial.domain.enums.Genero;
import com.dentali.features.historial.domain.enums.Nacionalidad;
import com.dentali.features.historial.domain.enums.Ocupaciones;
import com.dentali.features.historial.domain.enums.Religion;

public class PacienteResponseDTO {


	private Long id;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private Genero genero;
	private EstadoCivil estadoCivil;
	private Ocupaciones ocupacion;
	private Religion religion;
	private Nacionalidad nacionalidad;
	private String telefono;
	private String email;
	private String direccion;
	private LocalDateTime fechaRegistro;
	private LocalDateTime fechaActualizacion;
	private Boolean estado;

	public PacienteResponseDTO() {
	}

	public PacienteResponseDTO(Long id, String nombre, String apellido, LocalDate fechaNacimiento, 
			Genero genero, EstadoCivil estadoCivil, Ocupaciones ocupacion, Religion religion, Nacionalidad nacionalidad, String telefono,
			String email, String direccion, LocalDateTime fechaRegistro, LocalDateTime fechaActualizacion, Boolean estado) {
		this.id = id;
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
		this.fechaRegistro = fechaRegistro;
		this.fechaActualizacion = fechaActualizacion;
		this.estado = estado;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Genero getGenero() {
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

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
    

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
