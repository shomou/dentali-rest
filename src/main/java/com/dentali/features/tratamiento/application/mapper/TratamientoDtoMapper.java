package com.dentali.features.tratamiento.application.mapper;

import java.time.LocalDateTime;
import com.dentali.features.tratamiento.domain.enums.EstadoTratamiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.dentali.features.tratamiento.application.dto.request.TratamientoRequest;
import com.dentali.features.tratamiento.application.dto.response.TratamientoResponse;
import com.dentali.features.tratamiento.domain.model.Tratamiento;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = { LocalDateTime.class,
        EstadoTratamiento.class })
public interface TratamientoDtoMapper {

    // 1. Mapeo de Dominio a Respuesta (Salida API)
    TratamientoResponse toResponse(Tratamiento domain);

    // 2. Mapeo de Request a Dominio (Entrada API para creación)
    // Generamos los valores por defecto del negocio usando expresiones de Java
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fecha", expression = "java(LocalDateTime.now())")
    @Mapping(target = "estado", expression = "java(EstadoTratamiento.PENDIENTE)")
    Tratamiento toDomain(TratamientoRequest request);
}
