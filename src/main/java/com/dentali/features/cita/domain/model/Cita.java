package com.dentali.features.cita.domain.model;

import java.time.LocalDateTime;

import com.dentali.features.cita.domain.enums.EstadoCita;
import com.dentali.features.doctor.domain.model.Doctor;
import com.dentali.features.paciente.domain.model.Paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cita {
    private Long id;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;
    private String observaciones;
    private Paciente paciente;
    private Doctor doctor;
}
