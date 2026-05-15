package com.dentali.features.doctor.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DoctorRequest(

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    String nombre,
    
    @NotBlank(message = "El apellido no puede estar vacío")
    String apellido,
    String especialidad,
    String telefono,
    
    @NotBlank(message = "El email no puede estar vacío") @Email(message = "El email debe ser válido")
    String email

) {

}
