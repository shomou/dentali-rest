package com.dentali.features.tratamiento.infrastructure.persistence.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.dentali.features.tratamiento.domain.model.Tratamiento;
import com.dentali.features.tratamiento.infrastructure.persistence.jpa.entity.TratamientoEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TratamientoEntityMapper {
    /**
     * Convierte el modelo de dominio puro a la entidad JPA
     * lista para ser persistida por Spring Data JPA.
     */
    TratamientoEntity toEntity(Tratamiento domain);

    /**
     * Convierte la entidad recuperada de la base de datos PostgreSQL
     * de vuelta al modelo de dominio inmutable.
     */
    Tratamiento toDomain(TratamientoEntity entity);

}
