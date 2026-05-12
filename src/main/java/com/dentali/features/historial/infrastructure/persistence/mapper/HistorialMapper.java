package com.dentali.features.historial.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dentali.features.historial.domain.model.HistoriaClinica;
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
import com.dentali.features.historial.infrastructure.persistence.jpa.HistorialEntity;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AnalisisAtmVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AnalisisOclusionVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AntecedentesPatologicosVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.ContactoEmergenciaVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.ExploracionBucalVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.AntecedentesFamiliaresVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.HallazgoDentalVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.HigieneHabitosVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.InterrogatorioSistemasVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.NotaEvolucionVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.SaludFemeninaVO;
import com.dentali.features.historial.infrastructure.persistence.jpa.vo.SignosVitalesVO;

@Mapper(componentModel = "spring")
public interface HistorialMapper {

    // Mapeo principal: Dominio --> Entidad
    @Mapping(target = "notasEvolucion", source = "notasEvolucion")
    @Mapping(target = "analisisAtm", source = "analisisATM")
    HistorialEntity toEntity(HistoriaClinica domain);

    // Mapeo inverso: Entidad --> Dominio
    @Mapping(target = "notasEvolucion", source = "notasEvolucion")
    @Mapping(target = "analisisATM", source = "analisisAtm")
    HistoriaClinica toDomain(HistorialEntity entity);

    // Mapeo de Value Objects
    SignosVitalesVO map(SignosVitales value);
    SignosVitales map(SignosVitalesVO value);

    AntecedentesPatologicosVO map(AntecedentesPatologicos value);
    AntecedentesPatologicos map(AntecedentesPatologicosVO value);

    AnalisisAtmVO map(AnalisisAtm value);
    AnalisisAtm map(AnalisisAtmVO value);

    ContactoEmergenciaVO map(ContactoEmergencia value);
    ContactoEmergencia map(ContactoEmergenciaVO value);

    HigieneHabitosVO map(HigieneHabitos value);
    HigieneHabitos map(HigieneHabitosVO value);

    InterrogatorioSistemasVO map(InterrogatorioSistemas value);
    InterrogatorioSistemas map(InterrogatorioSistemasVO value);

    SaludFemeninaVO map(SaludFemenina value);
    SaludFemenina map(SaludFemeninaVO value);

    default AntecedentesFamiliaresVO map(AntecedentesFamiliares domain) {
        if (domain == null) return null;
        return new AntecedentesFamiliaresVO(
            domain.padecimientosFamiliares(),
            domain.observaciones()
        );
    }

    default AntecedentesFamiliares map(AntecedentesFamiliaresVO vo) {
        if (vo == null) return null;
        return new AntecedentesFamiliares(
            vo.getPadecimientosFamiliares(),
            vo.getObservaciones()
        );
    }

    ExploracionBucalVO map(ExploracionBucal value);
    ExploracionBucal map(ExploracionBucalVO value);

    AnalisisOclusionVO map(AnalisisOclusion value);
    AnalisisOclusion map(AnalisisOclusionVO value);

    // Mapeo de listas (Odontograma y Notas)
    List<HallazgoDentalVO> mapHallazgos(List<HallazgoDental> value);
    List<HallazgoDental> mapHallazgosEntity(List<HallazgoDentalVO> value);

    List<NotaEvolucionVO> mapNotas(List<NotasEvolucion> value);
    List<NotasEvolucion> mapNotasEntity(List<NotaEvolucionVO> value);

}
