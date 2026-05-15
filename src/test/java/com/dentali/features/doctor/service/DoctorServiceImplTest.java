package com.dentali.features.doctor.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dentali.features.auth.domain.Role;
import com.dentali.features.auth.domain.User;
import com.dentali.features.auth.repository.RoleRepository;
import com.dentali.features.auth.repository.UserRepository;
import com.dentali.features.doctor.domain.Doctor;
import com.dentali.features.doctor.dto.DoctorDTO;
import com.dentali.features.doctor.dto.DoctorResponseDTO;
import com.dentali.features.doctor.mapper.DoctorMapper;
import com.dentali.features.doctor.repository.DoctorRepository;
import com.dentali.features.doctor.service.impl.DoctorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceImplTest {

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private DoctorMapper doctorMapper;

    @InjectMocks
    private DoctorServiceImpl doctorService;

    private Doctor existingDoctor;
    private User associatedUser;
    private Role doctorRole;

    @BeforeEach
    void setUp() {
        existingDoctor = Doctor.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Perez")
                .especialidad("General")
                .telefono("123456")
                .email("juan@test.com")
                .build();
        
        doctorRole = new Role();
        doctorRole.setId(1L);
        doctorRole.setName("ROLE_DOCTOR");
        
        associatedUser = new User();
        associatedUser.setId(1L);
        associatedUser.setUsername("juan@test.com");
        associatedUser.setRoles(new ArrayList<>()); 
    }

    @Test
    void testUpdateDoctorAndUserRoles() {
        // GIVEN
        Long doctorId = 1L;
        DoctorDTO updateDTO = new DoctorDTO();
        updateDTO.setNombre("Juan Actualizado");
        updateDTO.setEmail("juan_nuevo@test.com");
        updateDTO.setRoles(List.of("ROLE_DOCTOR")); // Enviamos lista de roles
        updateDTO.setPassword("nueva123");

        when(doctorRepository.findById(doctorId)).thenReturn(Optional.of(existingDoctor));
        when(userRepository.findByUsername("juan@test.com")).thenReturn(Optional.of(associatedUser));
        when(roleRepository.findByName("ROLE_DOCTOR")).thenReturn(Optional.of(doctorRole));
        when(passwordEncoder.encode("nueva123")).thenReturn("encoded_password");
        
        // Simular el guardado
        when(doctorRepository.save(any(Doctor.class))).thenAnswer(i -> i.getArguments()[0]);
        when(doctorMapper.toResponseDTO(any(), any())).thenReturn(new DoctorResponseDTO());

        // WHEN
        Optional<DoctorResponseDTO> result = doctorService.update(doctorId, updateDTO);

        // THEN
        assertTrue(result.isPresent());
        
        // Verificar que el doctor se actualizó
        assertEquals("juan_nuevo@test.com", existingDoctor.getEmail());

        // Verificar que el usuario recibió la lista de roles
        assertEquals("juan_nuevo@test.com", associatedUser.getUsername());
        assertEquals("encoded_password", associatedUser.getPassword());
        assertEquals(1, associatedUser.getRoles().size());
        assertEquals("ROLE_DOCTOR", associatedUser.getRoles().get(0).getName());

        // Verificar llamadas
        verify(doctorRepository).save(existingDoctor);
        verify(userRepository).save(associatedUser);
    }
}
