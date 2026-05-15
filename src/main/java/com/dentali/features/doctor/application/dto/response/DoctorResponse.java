package com.dentali.features.doctor.application.dto.response;

import java.util.List;

public record DoctorResponse(
    Long id,
    String nombre,
    String apellido,
    String especialidad,
    String telefono,
    String email,
    List<String> roles
) {}