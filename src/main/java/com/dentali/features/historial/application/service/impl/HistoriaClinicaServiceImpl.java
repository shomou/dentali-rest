package com.dentali.features.historial.application.service.impl;

import com.dentali.features.historial.application.dto.request.HistoriaClinicaRequest;
import com.dentali.features.historial.application.dto.response.HistoriaClinicaResponse;
import com.dentali.features.historial.application.service.HistoriaClinicaService;
import com.dentali.features.historial.domain.enums.EstadoCivil;
import com.dentali.features.historial.domain.enums.GrupoSanguineo;
import com.dentali.features.historial.domain.enums.Nacionalidad;
import com.dentali.features.historial.domain.enums.Ocupaciones;
import com.dentali.features.historial.domain.enums.Religion;
import com.dentali.features.historial.domain.enums.SiNo;
import com.dentali.features.historial.domain.model.HistoriaClinica;
import com.dentali.features.historial.domain.model.vo.*;
import com.dentali.features.historial.domain.repository.HistorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {
    private final HistorialRepository repository;

    @Override
    @Transactional
    public HistoriaClinicaResponse registrar(HistoriaClinicaRequest dto) {
        // Mapeo manual del DTO al Objeto de Dominio (Rich Domain Model)
        HistoriaClinica historia = HistoriaClinica.builder()
                .pacienteId(dto.pacienteId())
                .fechaIngreso(LocalDate.now())
                .numeroExpediente(dto.numeroExpediente())
                .motivoConsulta(dto.motivoConsulta())
                .genero(dto.genero())
                .estadoCivil(EstadoCivil.valueOf(dto.estadoCivil().toString()))
                .ocupacion(Ocupaciones.valueOf(dto.ocupacion().toUpperCase()))
                .religion(Religion.valueOf(dto.religion().toUpperCase()))
                .nacionalidad(Nacionalidad.valueOf(dto.nacionalidad().toUpperCase()))
                .domicilio(dto.domicilio())
                .signosVitales(new SignosVitales(
                        dto.peso(),
                        dto.talla(),
                        GrupoSanguineo.valueOf(dto.grupoSanguineo()),
                        dto.presionArterial(),
                        dto.fr(),
                        dto.fc(),
                        dto.temperatura(),
                        dto.saturacionO2()))
                .antecedentesFamiliares(new AntecedentesFamiliares(
                        dto.padecimientosFamiliares(), dto.observacionesFamiliares()))
                .antecedentesPatologicos(new AntecedentesPatologicos(
                        dto.enfermedadesUltimoAno(),
                        transformarAPadecimientos(dto.padecimientosPatologicos()),
                        dto.observacionesPatologicas()))
                .planTratamiento(dto.planTratamiento())
                .build();

        // 2. Guardar en el Repositorio
        HistoriaClinica guardada = repository.guardar(historia);

        // 3. Convertir Dominio -> Response DTO
        return new HistoriaClinicaResponse(
                guardada.getId(),
                guardada.getPacienteId(),
                guardada.getNumeroExpediente(),
                guardada.getFechaIngreso(),
                guardada.getMotivoConsulta(),
                "Paciente Ejemplo", // Aquí vendría el nombre del paciente si tuvieras el servicio de Pacientes
                determinarEstadoGeneral(guardada),
                convertirMapSiNoAString(guardada.getAntecedentesPatologicos().padecimientos()));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HistoriaClinicaResponse> buscarPorPaciente(Long pacienteId) {
        // 1. Llamamos al repositorio (capa de dominio)
        // El repositorio ya nos devuelve un Optional<HistoriaClinica> gracias al Mapper
        // de Infra
        return repository.buscarPorPacienteId(pacienteId)
                .map(this::toResponse); // 2. Convertimos el dominio a Response DTO
    }

    // Método auxiliar para centralizar la conversión a Response
    private HistoriaClinicaResponse toResponse(HistoriaClinica historia) {
        return new HistoriaClinicaResponse(
                historia.getId(),
                historia.getPacienteId(),
                historia.getNumeroExpediente(),
                historia.getFechaIngreso(),
                historia.getMotivoConsulta(),
                "Nombre Paciente", // Aquí podrías integrar una llamada a un servicio de Pacientes
                "Estable", // Lógica de negocio para el estado
                convertirMapSiNoAString(historia.getAntecedentesPatologicos().padecimientos()));
    }

    private String determinarEstadoGeneral(HistoriaClinica historia) {
        // Lógica de negocio simple para el response
        return historia.getSignosVitales().tensionArterial().contains("120") ? "Estable" : "Seguimiento Requerido";
    }

    // Método auxiliar para la conversión
    private Map<String, SiNo> transformarAPadecimientos(Map<String, String> rawMap) {
        if (rawMap == null)
            return Collections.emptyMap();

        return rawMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> {
                            try {
                                // Convierte "si" o "SI" a SiNo.SI
                                return SiNo.valueOf(e.getValue().toUpperCase());
                            } catch (Exception ex) {
                                return SiNo.NO; // Valor por defecto en caso de error
                            }
                        }));
    }

    // Método auxiliar para que el constructor coincida
    private Map<String, String> convertirMapSiNoAString(Map<String, SiNo> mapaEnums) {
        if (mapaEnums == null)
            return Collections.emptyMap();
        return mapaEnums.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().name() // Convierte el Enum SiNo a String "SI" o "NO"
                ));
    }
}
