package com.dentali.features.doctor.application.mapper;

import com.dentali.features.doctor.application.dto.request.DoctorRegistrationRequest;
import com.dentali.features.doctor.application.dto.request.DoctorRequest;
import com.dentali.features.doctor.application.dto.response.DoctorResponse;
import com.dentali.features.doctor.domain.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorDtoMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    Doctor toDomain(DoctorRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    Doctor toDomain(DoctorRegistrationRequest request);

    @Mapping(target = "roles", source = "roles")
    DoctorResponse toResponse(Doctor doctor, List<String> roles);
}