package com.dentali.features.historial.infrastructure.persistence.jpa;

import com.dentali.features.historial.domain.enums.*;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AnalisisAtmVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AnalisisOclusionVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AntecedentesFamiliaresVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AntecedentesPatologicosVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.ContactoEmergenciaVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.ExploracionBucalVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.HallazgoDentalVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.HigieneHabitosVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.InterrogatorioSistemasVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.NotaEvolucionVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.SaludFemeninaVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.SignosVitalesVO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "historiales")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pacienteId;
    private LocalDate fechaIngreso;
    private String numeroExpediente;

    // Campos simples con Enums
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

    private String domicilio;
    private String telefonoPaciente;

    @Column(columnDefinition = "TEXT")
    private String motivoConsulta;

    // Guardamos los Vo con JSONB para postgreSQL
    @JdbcTypeCode(SqlTypes.JSON)
    private ContactoEmergenciaVO contactoEmergencia;

    @JdbcTypeCode(SqlTypes.JSON)
    private SignosVitalesVO signosVitales;

    @JdbcTypeCode(SqlTypes.JSON)
    private AntecedentesFamiliaresVO antecedentesFamiliares;

    @JdbcTypeCode(SqlTypes.JSON)
    private AntecedentesPatologicosVO antecedentesPatologicos;

    @JdbcTypeCode(SqlTypes.JSON)
    private SaludFemeninaVO saludFemenina;

    @JdbcTypeCode(SqlTypes.JSON)
    private HigieneHabitosVO higiene;

    @JdbcTypeCode(SqlTypes.JSON)
    private InterrogatorioSistemasVO sistemas;

    @JdbcTypeCode(SqlTypes.JSON)
    private ExploracionBucalVO exploracion;

    @JdbcTypeCode(SqlTypes.JSON)
    private AnalisisAtmVO analisisAtm;

    @JdbcTypeCode(SqlTypes.JSON)
    private AnalisisOclusionVO oclusion;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<HallazgoDentalVO> odontograma;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<NotaEvolucionVO> notasEvolucion;

    @Column(columnDefinition = "TEXT")
    private String planTratamiento;


}
