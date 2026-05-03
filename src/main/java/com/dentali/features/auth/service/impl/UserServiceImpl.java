package com.dentali.features.auth.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dentali.features.auth.domain.Role;
import com.dentali.features.auth.domain.User;
import com.dentali.features.auth.dto.LoginRequestDTO;
import com.dentali.features.auth.dto.UserDoctorRegistrationDTO;
import com.dentali.features.auth.dto.UserResponseDTO;
import com.dentali.features.auth.repository.RoleRepository;
import com.dentali.features.auth.repository.UserRepository;
import com.dentali.features.auth.service.JWTService;
import com.dentali.features.auth.service.UserService;
import com.dentali.features.doctor.dto.DoctorDTO;
import com.dentali.features.doctor.service.DoctorService;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // Lombok genera el constructor con los campos final
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final DoctorService doctorService;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder; // Inyectar el bean en lugar de crearlo aquí

    @Override
    @Transactional(readOnly = true) // Buena práctica para métodos de solo lectura
    public List<UserResponseDTO> findAll() {
        List<User> users = (List<User>) repository.findAll();
        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getRoles()
                                .stream()
                                .map(Role::getName)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByUserName(String username) {

        return repository.existsByUsername(username);
    }

    @Override
    public String verify(LoginRequestDTO loginRequest) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            String token = jwtService.generateToken(authentication.getName());
            return token;
        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciales inválidas", e); // O una excepción personalizada
        }
    }

    @Override
    @Transactional
    public UserDoctorRegistrationDTO registerUserWithDoctor(UserDoctorRegistrationDTO dto) {

        // 1. Mapear el DTO a la entidad User
        User newUser = new User();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));

        // Asignar roles de forma segura
        List<Role> roles = new ArrayList<>();
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(
                        () -> new RuntimeException("Error: El rol ROLE_USER no se encuentra en la base de datos."));

        if (dto.getRole() != null && dto.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
            roleRepository.findByName("ROLE_ADMIN").ifPresent(roles::add);

        } else {
            roles.add(userRole);
        }

        newUser.setRoles(roles);
        // 2. Guardar la entidad User
        repository.save(newUser);

        // 3. Mapear el DTO a un DoctorDTO para el DoctorService
        // Nota: Idealmente, DoctorService tendría un método que acepte una entidad
        // Doctor.
        // Como la interfaz actual requiere un DTO, hacemos el mapeo aquí.
        DoctorDTO doctorParaGuardar = new DoctorDTO();
        doctorParaGuardar.setNombre(dto.getNombre());
        doctorParaGuardar.setApellido(dto.getApellido());
        doctorParaGuardar.setEspecialidad(dto.getEspecialidad());
        doctorParaGuardar.setTelefono(dto.getTelefono());
        doctorParaGuardar.setEmail(dto.getEmail());
        doctorParaGuardar.setFechaRegistro(LocalDateTime.now());

        // 4. Guardar el doctor a través de su servicio
        DoctorDTO nuevoDoctorSaved = doctorService.guardar(doctorParaGuardar);

        // Comprobación robusta: verificar que el doctor se guardó y tiene un ID.
        if (nuevoDoctorSaved != null && nuevoDoctorSaved.getId() != null) {
            return dto;
        } else {
            // Esta excepción provocará un rollback de la transacción, por lo que el usuario
            // tampoco se creará.
            throw new RuntimeException("Error al crear el doctor asociado. La operación será revertida.");
        }
    }
}