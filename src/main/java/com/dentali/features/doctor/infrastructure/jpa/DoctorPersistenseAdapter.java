package com.dentali.features.doctor.infrastructure.jpa;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dentali.features.doctor.domain.model.Doctor;
import com.dentali.features.doctor.domain.repository.DoctorRepository;
import com.dentali.features.doctor.infrastructure.jpa.mapper.DoctorEntityMapper;
import com.dentali.features.doctor.infrastructure.jpa.repository.DoctorJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DoctorPersistenseAdapter implements DoctorRepository{

    private final DoctorJpaRepository jpaRepository;
    private final DoctorEntityMapper mapper;

    @Override
    @Transactional
    public Doctor save(Doctor doctor){
        if (doctor == null) {
            throw new IllegalArgumentException("El doctor no puede ser nulo");
        }
        DoctorEntity entidad = mapper.toEntity(doctor);

        if (entidad == null) {
            throw new IllegalStateException("Error interno: No se pudo mapear el doctor a la entidad de persistencia");
        }
        
        DoctorEntity saved = jpaRepository.save(entidad);
        return mapper.toDomain(saved);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> findById(Long id){
        if (id == null) {
            return Optional.empty();
        }
        return jpaRepository.findById(id)
            .map(mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Doctor> findByEmail(String email){
        if (email == null || email.isBlank()) {
            return Optional.empty();
        }
        return jpaRepository.findByEmail(email)
            .map(mapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll(){
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        if (id == null) {
            return;
        }
        jpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Doctor update(Doctor doctor){
        if (doctor == null) {
            throw new IllegalArgumentException("El doctor no puede ser nulo para actualizar");
        }
        // El método save de JpaRepository se encarga de actualizar sie elñ ID existe;
        // Aquí asumimos que el objeto Doctor que llega a actualizar ya tiene su ID
        DoctorEntity entityToUpdate = mapper.toEntity(doctor);

        if (entityToUpdate == null) {
            throw new IllegalStateException("Error interno: No se pudo mapear el doctor para la actualización");
        }

        DoctorEntity updatedEntity = jpaRepository.save(entityToUpdate);
        return mapper.toDomain(updatedEntity);
    }
    

}
