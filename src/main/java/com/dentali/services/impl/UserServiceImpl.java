package com.dentali.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.dentali.dto.DoctorDTO;
import com.dentali.dto.LoginRequestDTO;
import com.dentali.dto.UserDoctorRegistrationDTO;
import com.dentali.dto.UserResponseDTO;
import com.dentali.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dentali.entities.Role;
import com.dentali.entities.User;
import com.dentali.repositories.RoleRepository;
import com.dentali.repositories.UserRepository;
import com.dentali.services.JWTService;
import com.dentali.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor // Lombok genera el constructor con los campos final
public class UserServiceImpl implements UserService{

		
    private final UserRepository repository;
    private final DoctorService doctorService;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authManager;
    private final JWTService jwtService;
    private final BCryptPasswordEncoder encoder; // Inyectar el bean en lugar de crearlo aquí
	
    
    // Constructores
    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, AuthenticationManager authManager
    					, JWTService jwtService, BCryptPasswordEncoder encoder, DoctorService doctorService) {
    				this.repository = repository;
    				this.doctorService = doctorService;
    				this.roleRepository = roleRepository;
    				this.authManager = authManager;
    				this.jwtService = jwtService;
    				this.encoder = encoder;
		    }
	

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
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
      
        optionalRoleUser.ifPresent(roles::add);

        if(user.isAdmin()){
            Optional<Role> optionalRoleAdmin =  roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setPassword(encoder.encode(user.getPassword()));

        return repository.save(user);
    }

    @Override
    public boolean existsByUserName(String username) {
        
        return repository.existsByUsername(username);
    }

    @Override
    public String verify(LoginRequestDTO loginRequest) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            return jwtService.generateToken(loginRequest.getUsername());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciales inválidas", e); // O una excepción personalizada
        }
    }



    @Override
    @Transactional
    public UserDoctorRegistrationDTO registerUserWithDoctor(UserDoctorRegistrationDTO dto){

        // Crear y guardar el usuario
        User newUser = new User();
        List<Role> roles = new ArrayList<>();

        roleRepository.findByName("ROLE_USER").ifPresent(roles::add);

        if (dto.getRole() != null && dto.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
            roleRepository.findByName("ROLE_ADMIN").ifPresent(roles::add);
        }

        newUser.setUsername(dto.getUsername());
        newUser.setPassword(encoder.encode(dto.getPassword()));
        newUser.setRoles(roles);

        repository.save(newUser);

        // Crear y guardar el doctor asociado
        DoctorDTO nuevoDoctor = new DoctorDTO();
        DoctorDTO nuevoDoctorSaved = new DoctorDTO();

        nuevoDoctor.setNombre(dto.getNombre());
        nuevoDoctor.setApellido(dto.getApellido());
        nuevoDoctor.setEspecialidad(dto.getEspecialidad());
        nuevoDoctor.setTelefono(dto.getTelefono());
        nuevoDoctor.setEmail(dto.getEmail());

        nuevoDoctorSaved =  doctorService.guardar(nuevoDoctor);

        if (nuevoDoctorSaved.getNombre().equals(dto.getNombre())) {
        	return dto;
		} else {
			throw new RuntimeException("Error al crear el doctor asociado");
		}

    }
}