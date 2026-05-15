package com.dentali.features.doctor.infrastructure.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dentali.features.doctor.infrastructure.jpa.DoctorEntity;

@Repository
public interface DoctorJpaRepository extends JpaRepository<DoctorEntity, Long> {

        Optional<DoctorEntity> findByEmail(String email);


}
