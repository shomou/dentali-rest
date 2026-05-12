package com.dentali.features.historial.domain.model;

import java.time.LocalDate;
import java.util.List;

import com.dentali.features.historial.domain.enums.EstadoCivil;
import com.dentali.features.historial.domain.enums.Genero;
import com.dentali.features.historial.domain.enums.Nacionalidad;
import com.dentali.features.historial.domain.enums.Ocupaciones;
import com.dentali.features.historial.domain.enums.Religion;
import com.dentali.features.historial.domain.model.vo.AnalisisAtm;
import com.dentali.features.historial.domain.model.vo.AnalisisOclusion;
import com.dentali.features.historial.domain.model.vo.AntecedentesFamiliares;
import com.dentali.features.historial.domain.model.vo.AntecedentesPatologicos;
import com.dentali.features.historial.domain.model.vo.ContactoEmergencia;
import com.dentali.features.historial.domain.model.vo.ExploracionBucal;
import com.dentali.features.historial.domain.model.vo.HallazgoDental;
import com.dentali.features.historial.domain.model.vo.HigieneHabitos;
import com.dentali.features.historial.domain.model.vo.InterrogatorioSistemas;
import com.dentali.features.historial.domain.model.vo.NotasEvolucion;
import com.dentali.features.historial.domain.model.vo.SaludFemenina;
import com.dentali.features.historial.domain.model.vo.SignosVitales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class HistoriaClinica {
    
    private final Long id;
    private final Long pacienteId;
    private final LocalDate fechaIngreso;
    private final String numeroExpediente;
    
    // Datos Personales
    private final Genero genero;
    private final EstadoCivil estadoCivil;
    private final Ocupaciones ocupacion;
    private final Religion religion;
    private final Nacionalidad nacionalidad;
    private final String domicilio;
    private final String telefonoPaciente;
    
    
    private final ContactoEmergencia contactoEmergencia;

    // Secciones Medicas
    private final String motivoConsulta;    
    private final SignosVitales signosVitales;
    private final AntecedentesFamiliares antecedentesFamiliares;
    private final AntecedentesPatologicos antecedentesPatologicos;
    private final SaludFemenina saludFemenina;
    private final HigieneHabitos higiene;
    private final InterrogatorioSistemas sistemas;

    // Dentales Especializadas
    private final ExploracionBucal exploracion;
    private final AnalisisAtm analisisATM;
    private final AnalisisOclusion oclusion;
    private final List<HallazgoDental> odontograma;

    // Seguimiento
    private final List<NotasEvolucion> notasEvolucion;
    private final String planTratamiento;
}
