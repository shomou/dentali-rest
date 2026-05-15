package com.dentali.features.doctor.application.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dentali.core.exceptions.ConflictException;
import com.dentali.core.exceptions.ResourceNotFoundException;

import com.dentali.features.auth.application.service.AuthService;
import com.dentali.features.doctor.application.dto.request.DoctorRegistrationRequest;
import com.dentali.features.doctor.application.dto.request.DoctorRequest;
import com.dentali.features.doctor.application.dto.response.DoctorResponse;
import com.dentali.features.doctor.application.mapper.DoctorDtoMapper;
import com.dentali.features.doctor.application.service.DoctorService;
import com.dentali.features.doctor.domain.model.Doctor;
import com.dentali.features.doctor.domain.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;
    private final DoctorDtoMapper mapper;
    private final AuthService authService;


    @Override
    @Transactional
    public DoctorResponse actualizar(Long id, DoctorRequest request) {
        Doctor existingDoctor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con id: " + id));

        // Validar si el nuevo email ya está en uso por OTRO doctor
        repository.findByEmail(request.email()).ifPresent(d -> {
            if (!d.getId().equals(id)) {
                throw new ConflictException("El email ya está en uso por otro doctor");
            }
        });

        String oldEmail = existingDoctor.getEmail();

        // 1. Desacoplado: Usar AuthService para sincronizar el acceso
        authService.actualizarUsername(oldEmail, request.email());

        // Convertir Request a Dominio
        Doctor doctor = mapper.toDomain(request);
        doctor.setId(id);
        Doctor doctorGuardado = repository.save(doctor);
        List<String> roles = obtenerRolesDeUsuario(doctorGuardado.getEmail()); // Added roles
        return mapper.toResponse(doctorGuardado, roles); // Added roles
    }

    @Override
    @Transactional(readOnly = true)
    public DoctorResponse buscarDoctorPorEmail(String email) {
        return repository.findByEmail(email)
                .map(doctor -> {
                    List<String> roles = obtenerRolesDeUsuario(doctor.getEmail()); // Added roles
                    return mapper.toResponse(doctor, roles); // Added roles
                })
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con email: " + email));
    }

    @Override
    @Transactional(readOnly = true)
    public DoctorResponse buscarDoctorPorId(Long id) {
        return repository.findById(id)
                .map(doctor -> {
                    List<String> roles = obtenerRolesDeUsuario(doctor.getEmail()); // Added roles
                    return mapper.toResponse(doctor, roles); // Added roles
                })
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con id: " + id));
    }

    @Override
    @Transactional
    public DoctorResponse crear(DoctorRegistrationRequest request) {
        // Validar si ya existe el doctor con el mismo email
        if (existeDoctorConEmail(request.email())) {
            throw new ConflictException("Ya existe un doctor con el mismo email");
        }

        // 1. Desacoplado: Delegar a AuthService la creación del acceso
        if (!authService.existeUsuario(request.email())) {
            authService.registrarUsuario(request.email(), request.password(), List.of("ROLE_USER", "ROLE_DOCTOR"));
        }

        // Convertir Request a Dominio
        Doctor doctor = mapper.toDomain(request);
        
        Doctor doctorGuardado = repository.save(doctor);
        List<String> roles = obtenerRolesDeUsuario(doctorGuardado.getEmail()); // Added roles
        return mapper.toResponse(doctorGuardado, roles); // Added roles
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
         repository.findById(id).ifPresentOrElse(doctor -> {
            if (doctor.getEmail() == null) {
                 throw new ConflictException("No se puede eliminar el acceso: el doctor no tiene email asociado.");
            }

            // Desacoplado: AuthService se encarga de borrar el usuario
            authService.eliminarUsuario(doctor.getEmail());
            
            repository.deleteById(id);
        }, () -> {
            throw new ResourceNotFoundException("No se puede eliminar: Doctor no encontrado");
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<DoctorResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(doctor -> {
                    List<String> roles = obtenerRolesDeUsuario(doctor.getEmail());
                    return mapper.toResponse(doctor, roles); // Added roles
                })
                .toList();
    }

    private List<String> obtenerRolesDeUsuario(String email) {
        return authService.obtenerRolesPorUsername(email);
    }

    private boolean existeDoctorConEmail(String email) {
        return repository.findByEmail(email).isPresent();
    }

}
