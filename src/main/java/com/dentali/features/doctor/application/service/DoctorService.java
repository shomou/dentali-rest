package com.dentali.features.doctor.application.service;

import java.util.List;

import com.dentali.features.doctor.application.dto.request.DoctorRegistrationRequest;
import com.dentali.features.doctor.application.dto.request.DoctorRequest;
import com.dentali.features.doctor.application.dto.response.DoctorResponse;


public interface DoctorService {

    DoctorResponse crear(DoctorRegistrationRequest request);
    DoctorResponse buscarDoctorPorId(Long id);
    DoctorResponse buscarDoctorPorEmail(String email);
    List<DoctorResponse> listarTodos();
    DoctorResponse actualizar(Long id, DoctorRequest request);
    void eliminar(Long id);


}
