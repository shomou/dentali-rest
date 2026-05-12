package com.dentali.features.paciente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dentali.features.historial.domain.enums.EstadoCivil;
import com.dentali.features.historial.domain.enums.Genero;
import com.dentali.features.historial.domain.enums.Nacionalidad;
import com.dentali.features.historial.domain.enums.Ocupaciones;
import com.dentali.features.historial.domain.enums.Religion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;

	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	@Enumerated(EnumType.STRING)
	private Ocupaciones ocupacion;

	@Enumerated(EnumType.STRING)
	private Religion religion;

	@Enumerated(EnumType.STRING)
	private Nacionalidad nacionalidad;


	private String telefono;
	private String email;
	private String direccion;
	
	@CreationTimestamp
	@Column(name = "fecha_registro")
	private LocalDateTime fechaRegistro;

	@UpdateTimestamp
	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	@Column(name = "estado", nullable = false)
	private Boolean estado = true;

}
