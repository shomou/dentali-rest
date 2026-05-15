package com.dentali.features.paciente.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.dentali.features.paciente.domain.enums.Genero;
import com.dentali.features.paciente.domain.enums.EstadoPaciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion; // DNI, Cédula, Pasaporte
    private LocalDate fechaNacimiento;
    private Genero genero;
    private EstadoPaciente estado;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimaActualizacion;


    // Lógica de Dominio: Cálculo de edad dinámico
    public int getEdad(){
        if(this.fechaNacimiento == null)return 0;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
    // Lógica de Dominio: Formateo de nombre completo
    public String getNombreCompleto(){
        return String.format("%s %s",nombre, apellido);
    }

    // Lógica de Dominio: Regla de negocio para consentimientos
    public boolean esMenorDeEdad(){
        return getEdad() < 18;
    }

}
