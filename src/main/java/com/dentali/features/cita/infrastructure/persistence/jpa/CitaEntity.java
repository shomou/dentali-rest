package com.dentali.features.cita.infrastructure.persistence.jpa;

import java.time.LocalDateTime;
import com.dentali.features.cita.domain.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "citas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCita estado;

    private String observaciones;

    @Column(name = "paciente_id")
    private Long pacienteId;

    @Column(name = "doctor_id")
    private Long doctorId;
}