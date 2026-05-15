package com.dentali.features.doctor.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

	private Long id;
	private String nombre;
	private String apellido;
	private String especialidad;
	private String telefono;
	private String email;
	private LocalDateTime fechaRegistro;

	
	
}
