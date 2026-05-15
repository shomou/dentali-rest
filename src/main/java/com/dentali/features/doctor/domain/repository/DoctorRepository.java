package com.dentali.features.doctor.domain.repository;

import java.util.List;
import java.util.Optional;

import com.dentali.features.doctor.domain.model.Doctor;

public interface DoctorRepository {
    Doctor save(Doctor doctor);
    Optional<Doctor> findById(Long id);
    Optional<Doctor> findByEmail(String email);
    List<Doctor> findAll();
    void deleteById(Long id);
    Doctor update(Doctor doctor);
}
